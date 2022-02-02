package com.revature.tourofheroes.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.tourofheroes.models.Hero;
import com.revature.tourofheroes.models.HeroType;

public class HeroDAO {
	public List<Hero> getAllHeroes() {
		List<Hero> allHeroes = new ArrayList<Hero>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from heroes";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				allHeroes.add(
						new Hero(
								rs.getInt("id"),
								rs.getString("alias"),
								rs.getString("real_name"),
								rs.getString("power"),
								HeroType.valueOf(rs.getString("hero_type"))
								)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allHeroes;
	}
}
