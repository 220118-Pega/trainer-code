package com.revature.stacklite.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

public class DBRepository implements IRepository{
	private DAO<Issue,Integer> issueDAO;
	private DAO<Solution,Integer> solutionDAO;
	
	
	public DBRepository(DAO<Issue,Integer> issueDAO, DAO<Solution, Integer> solutionDAO) {
		this.issueDAO = issueDAO;
		this.solutionDAO = solutionDAO;
	}
	@Override
	public void addIssue(Issue newIssue) {
		// TODO Auto-generated method stub
		issueDAO.add(newIssue);
	}

	@Override
	public List<Issue> getIssues() {
		// TODO Auto-generated method stub
		return issueDAO.findAll();
	}

	@Override
	public Issue getIssueById(int id) throws Exception {
		// What the bl requires isn't the version of the issue
		// that the issueDAO.findById returns
		// What you need is the issue with the solutions suggested
		// for it 
		Issue issueWanted = issueDAO.findById(id);
		List<Solution> allSolutions = solutionDAO.findAll();
		//issueWanted.setSolutions(allSolutions.stream().filter(soln -> soln.getIssueId() == id).toList());
		// the singular line above is equivalent to
		List<Solution> solutions4Issue = new ArrayList<Solution>();
		for(Solution soln:allSolutions)
		{
			if(soln.getIssueId() == id) solutions4Issue.add(soln);
		}
		issueWanted.setSolutions(solutions4Issue);
		
		return issueWanted;
		
//		try(Connection conn = ConnectionFactory.getInstance().getConnection())
//		{
//			String query = "select * from issues inner join solutions on issues.id = solutions.issue_id where issues.id = ?";
//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			int ctr = 0;
//			Issue issueWanted2 = new Issue();
//			ArrayList<Solution> solutionsOfIssue = new ArrayList<Solution>();
//			while(rs.next()) {
//				//unpack my result set here
//				if(ctr == 0) {
//					issueWanted2.setId(rs.getInt("id"));
//					issueWanted2.setTitle(rs.getString("title"));
//					issueWanted2.setDescription(rs.getString("description"));
//					++ctr;
//				}
//				solutionsOfIssue.add(new Solution(
//							rs.getString("answer"),
//							rs.getInt("id"),
//							rs.getInt("upvote"),
//							rs.getInt("issue_id")
//						));
//				
//			}
//			issueWanted2.setSolutions(solutionsOfIssue);
//			return issueWanted2;
//		}
		
	}

	@Override
	public void addSolution(Solution newSolution) throws Exception {
		// TODO Auto-generated method stub
		solutionDAO.add(newSolution);
		
	}
	@Override
	public void updateSolution(Solution updatedSolution) {
		// TODO Auto-generated method stub
		solutionDAO.update(updatedSolution);
	}
	@Override
	public Solution getSolutionById(int id) {
		// TODO Auto-generated method stub
		return solutionDAO.findById(id);
	}
	
}
