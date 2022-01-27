package com.revature.stacklite.dl;

import java.util.List;

import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

/**
 * This is a interface for my repository implementations
 * Contains the necessary methods my BL needs to interact with my data storage
 * @author MarielleNolasco
 *
 */
public interface IRepository{
	void addIssue(Issue newIssue);
	List<Issue> getIssues();
	Issue getIssueById(int id) throws Exception;
	void addSolution(Solution newSolution) throws Exception;
	void updateSolution(Solution updatedSolution);
	Solution getSolutionById(int id);
}
