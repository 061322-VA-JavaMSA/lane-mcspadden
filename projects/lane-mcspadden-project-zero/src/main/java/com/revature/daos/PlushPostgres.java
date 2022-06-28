package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AnimePlush;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlushPostgres implements PlushDAO {

	private static Logger log = LogManager.getLogger(PlushPostgres.class);
	
	@Override
	public AnimePlush createPlush(AnimePlush p) {
		// TODO Auto-generated method stub
		String sql = "insert into shopitems (item_name, item_desc, item_price, item_state) values (?,?,?, ?)";
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setInt(3, p.getPrice());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("item_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AnimePlush> retrievePlush() {
		// TODO Auto-generated method stub
		String sql = "select * from shopitems;";
		List<AnimePlush> plush = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				AnimePlush p = new AnimePlush();
				p.setId(rs.getInt("item_id"));
				p.setName(rs.getString("item_name"));
				p.setDescription(rs.getString("item_desc"));
				p.setPrice(rs.getInt("item_price"));
				p.setStatus(rs.getString("item_state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AnimePlush retrievePlushById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnimePlush> retrievePlushByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePlush(AnimePlush p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
