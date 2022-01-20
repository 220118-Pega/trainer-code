package com.revature.stacklite.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.stacklite.models.Issue;

/**
 * Repository that connects to an inmemory storage, i.e, a static list of issues and solutions
 * @author MarielleNolasco
 *
 */
public class InMemoryRepository implements IRepository {
	private static List<Issue> listOfIssues; 
	private static int latestId;
	
	public InMemoryRepository() {
		// seeding my list of issues with dummy data
		listOfIssues = new ArrayList<Issue>(){{
			new Issue("Code doesn't work, why??", "My code doesn't work I don't know why", 1);
			new Issue("Code works??", "My code works I don't know why", 2);
		}};
		latestId = 3;
	}

	@Override
	public void addIssue(Issue newIssue) {
		// TODO Auto-generated method stub
		newIssue.setId(latestId);
		listOfIssues.add(newIssue);
		latestId++;
	}

	@Override
	public List<Issue> getIssues() {
		// TODO Auto-generated method stub
		return this.listOfIssues;
	}


}
