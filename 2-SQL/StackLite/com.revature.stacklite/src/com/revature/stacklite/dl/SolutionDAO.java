package com.revature.stacklite.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.stacklite.models.Solution;

public class SolutionDAO implements DAO<Solution, Integer> {

	@Override
	public Solution findById(Integer id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from solutions where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Solution(rs.getString("answer"), rs.getInt("id"), rs.getInt("upvote"), rs.getInt("issue_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Solution> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from solutions";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				solutions.add(new Solution(rs.getString("answer"), rs.getInt("id"), rs.getInt("upvote"), rs.getInt("issue_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solutions;
	}

	@Override
	public void add(Solution newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into solutions (issue_id, answer, upvote) values (?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getIssueId());
			pstmt.setString(2, newObject.getAnswer());
			pstmt.setInt(3, newObject.getUpvote());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Solution newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "update solutions set upvote = ?, answer = ? where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getUpvote());
			pstmt.setString(2, newObject.getAnswer());
			pstmt.setInt(3, newObject.getId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
