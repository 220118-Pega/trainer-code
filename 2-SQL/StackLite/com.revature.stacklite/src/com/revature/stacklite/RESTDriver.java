package com.revature.stacklite;

import com.revature.stacklite.bl.IssueBL;
import com.revature.stacklite.controllers.IController;
import com.revature.stacklite.controllers.IssueController;
import com.revature.stacklite.dl.DBRepository;
import com.revature.stacklite.dl.IssueDAO;
import com.revature.stacklite.dl.SolutionDAO;

import io.javalin.Javalin;

public class RESTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Controllers 
		IController issueController = new IssueController(new IssueBL(new DBRepository(new IssueDAO(), new SolutionDAO())));
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> {ctx.result("Hello World!");});
		app.get("/Issues", issueController.getAll());
	}

}
