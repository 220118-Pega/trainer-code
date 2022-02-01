package com.revature.stacklite.bl;

import java.util.List;

import com.revature.stacklite.dl.IRepository;
import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

public class IssueBL implements IIssueBL {
	private IRepository repo; 
	public IssueBL(IRepository repo)
	{
		this.repo = repo;
	}
	@Override
	public void addIssue(Issue issue) {
		// call my dl 
		repo.addIssue(issue);
	}
	@Override
	public List<Issue> getIssues()
	{
		return repo.getIssues();
	}
	@Override
	public Issue getIssueById(int id) throws Exception {
		// TODO Auto-generated method stub
		return repo.getIssueById(id);
	}
	@Override
	public void addSolution(Solution solution) throws Exception {
		// TODO Auto-generated method stub
		repo.addSolution(solution);
	}
	@Override
	public void upVoteSolution(int id) {
		// TODO Auto-generated method stub
		Solution solution2UpVote = repo.getSolutionById(id);
		int currentUpvote = solution2UpVote.getUpvote();
		try {
			// diff ++x vs x++: both increment x but ++x returns incremented value, x++ returns old value, then increments value of x
			solution2UpVote.setUpvote(++currentUpvote);
			repo.updateSolution(solution2UpVote);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateSolution(Solution updatedSolution) {
		// TODO Auto-generated method stub
		repo.updateSolution(updatedSolution);
	}
	@Override
	public void updateSolution(Integer solutionId, Integer newUpVote) {
		// TODO Auto-generated method stub
		Solution solution2Update = repo.getSolutionById(solutionId);
		try {
			solution2Update.setUpvote(newUpVote);
			repo.updateSolution(solution2Update);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
