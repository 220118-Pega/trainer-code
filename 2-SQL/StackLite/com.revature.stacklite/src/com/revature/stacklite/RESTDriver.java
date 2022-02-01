package com.revature.stacklite;

import com.revature.stacklite.bl.IssueBL;
import com.revature.stacklite.controllers.IController;
import com.revature.stacklite.controllers.IssueController;
import com.revature.stacklite.controllers.SolutionController;
import com.revature.stacklite.dl.DBRepository;
import com.revature.stacklite.dl.IssueDAO;
import com.revature.stacklite.dl.SolutionDAO;
import com.revature.stacklite.utils.Router;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;


public class RESTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Controllers 
		IController issueController = new IssueController(new IssueBL(new DBRepository(new IssueDAO(), new SolutionDAO())));
		IController solutionController = new SolutionController(new IssueBL(new DBRepository(new IssueDAO(), new SolutionDAO())));
		Javalin app = Javalin.create(config -> {
			config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
		}).start(7000);
		Router router = new Router(app, issueController, solutionController);
		router.setUpEndPoints();
	}

	private static OpenApiOptions getOpenApiOptions() {
		// Configuring swagger
		// We'll use swagger for documentation and testing our API
		Info applicationInfo = new Info().version("1.0").description("Stacklite REST");
		return new OpenApiOptions(applicationInfo).path("/swagger-docs")
				.swagger(new SwaggerOptions("/swagger").title("StackLite API Docs"));
	}

}
