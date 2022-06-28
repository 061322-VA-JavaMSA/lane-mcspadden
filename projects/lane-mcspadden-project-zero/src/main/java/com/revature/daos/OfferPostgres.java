package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDAO {

	@Override
	public Offer createOffer(Offer o) {
		// TODO Auto-generated method stub
		String sql = "insert into offers (item_id, user_id, offer) values (?, ?, ?);";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, o.getItem_id());
			ps.setInt(2,o.getUser_id());
			ps.setInt(3, o.getOffer());
			
			ResultSet rs = ps.executeQuery();
			
			
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
	public List<Offer> retrieveOffers() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Offer retrievePlushById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> retrievePlushByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePlush(Offer o) {
		// TODO Auto-generated method stub
		return false;
	}

}
