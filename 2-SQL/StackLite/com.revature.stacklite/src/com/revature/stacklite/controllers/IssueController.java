package com.revature.stacklite.controllers;

import com.revature.stacklite.bl.IIssueBL;

import io.javalin.http.Handler;

public class IssueController implements IController {

	private IIssueBL issueBL;
	
	public IssueController(IIssueBL issueBL)
	{
		this.issueBL = issueBL;
	}
	@Override
	public Handler getAll() {
		// Do note that the Handler is a fcnal interface
		// A means to pass functions as parameters 
		// We'll be returning a lambda function
		// as an implementation for this fcnal interface
		// the lambda we'll be returning is how we want
		// our httprequest to be handled
		return ctx -> {
			// marshalling my list of issues to a json format
			// jsonStream() sets the response body to json
			ctx.jsonStream(issueBL.getIssues());
		};
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return null;
	}

}
