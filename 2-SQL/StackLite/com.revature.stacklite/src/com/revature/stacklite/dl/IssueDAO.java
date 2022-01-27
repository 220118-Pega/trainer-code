package com.revature.stacklite.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.stacklite.models.Issue;

public class IssueDAO implements DAO<Issue, Integer> {
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public Issue findById(Integer id) {
		// try with resources block, after the try block finishes executing, it
		// disposes of the resources for you
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// ? is a placeholder for parameter we'll be sending our DB
			String query = "select * from issues where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// executeQuery - used for executing select commands
			// result set - holds the results from the DB
			ResultSet rs = pstmt.executeQuery();
			// we need to unpack result set to return something to end user
			if (rs.next()) {
				return new Issue(rs.getString("title"), rs.getString("description"), rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error with connecting to the DB");
		}
		return null;
	}

	@Override
	public List<Issue> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Issue> issues = new ArrayList<Issue>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from issues";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				issues.add(
						new Issue(
								rs.getString("title"), 
								rs.getString("description"), 
								rs.getInt("id"))
								);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
		return issues;
	}

	@Override
	public void add(Issue newObject) {
		// TODO Auto-generated method stub
		try(Connection conn= ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into issues (title, description) values (?,?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newObject.getTitle());
			pstmt.setString(2, newObject.getDescription());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Issue newObject) {
		// TODO Auto-generated method stub

	}

}
