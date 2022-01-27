package com.revature.stacklite.dl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

/**
 * Repository that connects to an inmemory storage, i.e, a static list of issues and solutions
 * @author MarielleNolasco
 *
 */
public class InMemoryRepository implements IRepository {
	private static ArrayList<Issue> listOfIssues; 
	private static int latestId;
	private Logger logger = LogManager.getLogger(this.getClass());
	public InMemoryRepository() {
		// seeding my list of issues with dummy data
		List<Solution> solutionListA = new ArrayList<Solution>() {{
			add(new Solution("Maybe read through the errors?", 2, 1));
			add(new Solution("Maybe read through the tears?", 0, 2));
		}};
		listOfIssues = new ArrayList<Issue>(){{
			add(new Issue("Code doesn't work, why??", "My code doesn't work I don't know why", 1, solutionListA));
			add(new Issue("Code works??", "My code works I don't know why", 2));
		}};
//		listOfIssues = Arrays.asList(
//				new Issue("Code doesn't work, why??", "My code doesn't work I don't know why", 1),
//				new Issue("Code works??", "My code works I don't know why", 2));
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
		return listOfIssues;
	}

	@Override
	public Issue getIssueById(int id) throws Exception {
		// throw vs throws:
		// throw keyword in code block, throws keyword in method signature
		Issue foundIssue = null;
		for(Issue issue:listOfIssues)
		{
			if(issue.getId() == id)
			{
				foundIssue = issue;
			}
		}
		if(foundIssue == null) {
			logger.error("Issue not found");
			throw new Exception("Issue not found");
		}
		return foundIssue;
	}

	@Override
	public void addSolution(Solution newSolution) throws Exception {
		// TODO Auto-generated method stub
		Issue issue2Update = getIssueById(newSolution.getIssueId());
		List<Solution> existingSolutions = issue2Update.getSolutions();
		if(existingSolutions == null) existingSolutions = new ArrayList<Solution>();
		existingSolutions.add(newSolution);
		issue2Update.setSolutions(existingSolutions);
	}


}
