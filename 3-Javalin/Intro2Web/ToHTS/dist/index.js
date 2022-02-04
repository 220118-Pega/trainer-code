"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// note that when declaring stuff, you assign it a type
function GetAllHeroes() {
    fetch("https://localhost:5001/api/hero")
        .then(function (response) { return response.json(); })
        .then(function (responseBody) { return PrintHeroesTable(responseBody); });
}
function PrintHeroesTable(heroes) {
    document.querySelectorAll('#heroes tbody tr').forEach(function (row) { return row.remove(); });
    //using the union to set the table element to either be of type HTMLTableElement (which is an interface) or null
    var table = document.querySelector('#heroes tbody');
    //leveraging the truthiness of the table value
    if (table) {
        //for each hero from the server, add a row to the table
        for (var i = 0; i < heroes.length; ++i) {
            //inserting a row at the bottom of a table
            var row = table.insertRow(table.rows.length);
            //inserting a data cell of index 0 at the row
            var heroNameCell = row.insertCell(0);
            //setting the data of that cell to be the current hero's name
            heroNameCell.innerHTML = heroes[i].heroName;
            var hpCell = row.insertCell(1);
            hpCell.innerHTML = heroes[i].hp.toString();
            var elementCell = row.insertCell(2);
            elementCell.innerHTML = heroes[i].elementType.toString();
            var spNameCell = row.insertCell(3);
            spNameCell.innerHTML = heroes[i].superPower.name;
            var spDescCell = row.insertCell(4);
            spDescCell.innerHTML = heroes[i].superPower.description;
            var spDmgCell = row.insertCell(5);
            spDmgCell.innerHTML = heroes[i].superPower.damage.toString();
        }
    }
}
function AddAHero() {
    var hero2Add = {
        heroName: document.querySelector('#heroName').value,
        hp: parseInt(document.querySelector('#hp').value),
        elementType: parseInt(document.querySelector('#elementType').value),
        superPower: {
            name: document.querySelector('#superPowerName').value,
            description: document.querySelector('#superPowerDesc').value,
            damage: parseInt(document.querySelector('#superPowerDmg').value)
        }
    };
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status > 199 && this.status < 300) {
            console.log("a hero has been added");
            document.querySelector('#heroName').value = '';
            document.querySelector('#hp').value = '';
            document.querySelector('#elementType').value = '';
            document.querySelector('#superPowerName').value = '';
            document.querySelector('#superPowerDesc').value = '';
            document.querySelector('#superPowerDmg').value = '';
            GetAllHeroes();
        }
    };
    xhr.open("POST", "https://localhost:5001/api/hero", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(hero2Add));
}
