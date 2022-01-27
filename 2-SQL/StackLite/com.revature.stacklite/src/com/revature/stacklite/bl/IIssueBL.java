package com.revature.stacklite.bl;

import java.util.List;

import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

public interface IIssueBL {

	void addIssue(Issue issue);

	List<Issue> getIssues();
	Issue getIssueById(int id) throws Exception;
	void addSolution(Solution solution) throws Exception;
}