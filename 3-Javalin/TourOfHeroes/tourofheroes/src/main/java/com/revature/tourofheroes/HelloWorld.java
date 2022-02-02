
package com.revature.tourofheroes;


import com.revature.tourofheroes.models.Hero;
import com.revature.tourofheroes.storage.HeroDAO;

import io.javalin.Javalin;

public class HelloWorld {
  public static void main(String[] args) {
//    Javalin app = Javalin.create().start(7000);
//    app.get("/", ctx -> ctx.result("Hello World"));
    
    HeroDAO heroDAO = new HeroDAO();
    for(Hero hero:heroDAO.getAllHeroes())
    {
    	System.out.println(hero);
    }
  }
}
