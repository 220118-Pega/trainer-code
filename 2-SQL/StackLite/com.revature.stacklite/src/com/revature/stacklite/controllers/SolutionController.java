package com.revature.stacklite.controllers;

import com.revature.stacklite.bl.IIssueBL;
import com.revature.stacklite.models.Solution;

import io.javalin.http.Handler;

public class SolutionController implements IController{
	private IIssueBL issueBL;
	
	public SolutionController(IIssueBL issueBL)
	{
		this.issueBL = issueBL;
	}
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			issueBL.addSolution(ctx.bodyStreamAsClass(Solution.class));
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return ctx -> {
			issueBL.updateSolution(ctx.bodyStreamAsClass(Solution.class));
			ctx.status(204);
		};
	}
	
}
