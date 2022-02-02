
package com.revature.tourofheroes;

import com.revature.tourofheroes.models.Hero;
import com.revature.tourofheroes.storage.HeroDAO;

import io.javalin.Javalin;

public class HelloWorld {
	public static void main(String[] args) {
		HeroDAO heroDAO = new HeroDAO();
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		// technically to set up an endpoint you just need two things
		// 1: String path
		// 2. Action, when you get to this endpoint what is your code doing
		// method params: String endPoint, Handler (what are you doing at the endpoint)
		// Handler is a fcnal interface, contains only one method, you pass in fcns as
		// implementations of this interface
		app.get("/heroes", ctx -> ctx.jsonStream(heroDAO.getAllHeroes()));
		app.get("/heroes/{hero_id}", ctx -> {
			String stringId = ctx.pathParam("hero_id");
			int id = Integer.parseInt(stringId);
			Hero heroById = heroDAO.getHeroById(id);
			ctx.jsonStream(heroById);
		});
		app.post("/heroes", ctx -> heroDAO.addHero(ctx.bodyStreamAsClass(Hero.class)));
	}
}
