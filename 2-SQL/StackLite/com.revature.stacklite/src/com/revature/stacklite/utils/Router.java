package com.revature.stacklite.utils;

import com.revature.stacklite.controllers.IController;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

/**
 * Class in charge of mapping endpoints to the controller methods that would handle the http request
 *
 * @author MarielleNolasco
 *
 */
public class Router {
	// Your router is the front controller in the front controller design pattern 
	private Javalin app;
	private IController issueController;
	private IController solutionController;
	public Router(Javalin app, IController issueController, IController solutionController)
	{
		this.app = app;
		this.issueController = issueController;
		this.solutionController = solutionController;
	}
	
	public void setUpEndPoints() {
		app.get("/Issues", OpenApiBuilder.documented(DocumentationFactory.getDoc("getIssues"), issueController.getAll()));
		app.get("/Issues?",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getIssueById"), issueController.getById()));
		app.post("/Issues",  OpenApiBuilder.documented(DocumentationFactory.getDoc("addIssue"), issueController.add()));
		app.post("/Issues/{issue_id}/Solutions", OpenApiBuilder.documented(DocumentationFactory.getDoc("addSolution"), solutionController.add()));
		app.put("/Issues/{issue_id}/Solutions", OpenApiBuilder.documented(DocumentationFactory.getDoc("updateSolution"), solutionController.update()));
	}
}
