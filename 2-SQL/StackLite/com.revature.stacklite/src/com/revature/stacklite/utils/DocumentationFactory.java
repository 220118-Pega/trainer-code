package com.revature.stacklite.utils;

import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;

/**
 * return documentation for my endpoints
 * @author MarielleNolasco
 *
 */
public class DocumentationFactory {
	public static OpenApiDocumentation getDoc(String endPoint)
	{
		switch (endPoint)
		{
		case "getIssues":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Issue");
			}).jsonArray("200", Issue.class);
		case "getIssueById":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Issue");
			}).json("200", Issue.class);
		case "addIssue":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Issue");
			}).body(Issue.class).result("201");
		case "addSolution":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Solution");
			}).body(Solution.class).result("201");
		case "updateSolution":
			return OpenApiBuilder.document().operation(op -> 
			{
				op.addTagsItem("Solution");
			}).queryParam("upvote", Integer.class).result("204");
		case "getSolution":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Solution");
			}).json("200", Solution.class);
		default:
			return null;
		}
	}
	
}
