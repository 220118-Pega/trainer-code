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
}
