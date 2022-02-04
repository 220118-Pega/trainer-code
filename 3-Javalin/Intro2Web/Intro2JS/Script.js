// JS stands for Javascript
// JS to Java is like hamster is to ham
// The creator's of JS wanted to capitalize on Java's popularity
// JS is dynamically typed. Infers type of var
// JS datatypes: FUNSBONS
//  Stands for Functions, undefined, numbers, boolean, objects, null, symbols, strings
// Truthy, Falsy thingy
// In js all vars have an equivalent boolean value
// Falsy: FUN0NE
// False, undefined, null, +-0, "", NaN
// Created by Brendan Eich, @brendaneich

// AJAX
// Async JS and XML

function getPokemon(){
    //used to send HTTP requests
    let xhr = new XMLHttpRequest();
    // creating an empty object
    let pokemon = {};
    // Accessing the DOM
    // Document Object Model, a tree representation of your webpage
    // Tags are nodes, and tags within other tags are child nodes
    // Body tag is a node with children nodes of your divs in the body
    // with JS you can manipulate the dom
    // dynamically change the way your html doc is structured
    let pokemon2Find = document.getElementById('pokemon2Find').value;
    console.log(pokemon2Find);

    // assemble the http request
    // http method, endpoint, if you wanna run it async
    // String interpolation in js uses back ticks and ${variableName}
    xhr.open('GET', `https://pokeapi.co/api/v2/pokemon/${pokemon2Find}`, true);
    
    // send the request
    xhr.send();

    // define what happens after request is sent
    // ready state describes state of your request
    // 0 - uninitialized
    // 1 - loading (server connection established) the open method has been invoked
    // 2 - loaded (request received by server) send has been called
    // 3 - interactive (processing request) response body is being received
    // 4 - complete (response received) 
    xhr.onreadystatechange = function () {
        // check if the response is received AND the status code is successful
        if (this.readyState == 4 && this.status == 200)
        {
            // deserialize the JSON
            // deserialize the response body
            pokemon = JSON.parse(xhr.responseText);
            document.querySelector('#pokemonPicture').setAttribute('src', pokemon.sprites.front_shiny);
            document.querySelector('#pokemon2Find').value = '';
            }
    }

}