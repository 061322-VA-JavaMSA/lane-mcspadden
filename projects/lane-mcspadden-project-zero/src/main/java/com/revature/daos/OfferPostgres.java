package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.Offer;
import com.revature.models.OfferStatus;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements OfferDAO {

	private static Logger log = LogManager.getLogger(Driver.class);

	
	@Override
	public Offer createOffer(Offer o) {
		// TODO Auto-generated method stub
		String sql = "insert into item_offers (item_id, user_id, offer, status) values (?, ?, ?, CAST(? as accrej));";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, o.getItem_id());
			ps.setInt(2,o.getUser_id());
			ps.setInt(3, o.getOffer());
			ps.setString(4, OfferStatus.PENDING.toString());
			
			ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<Offer> retrieveOffers() {
		// TODO Auto-generated method stub
		List<Offer> list = new ArrayList<>();
		String sql = "select * from item_offers where status = 'PENDING'";

		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Offer o = new Offer();
				o.setOffer_id(rs.getInt("offer_id"));
				o.setItem_id(rs.getInt("item_id"));
				o.setUser_id(rs.getInt("user_id"));
				o.setOffer(rs.getInt("offer"));
				
				
				list.add(o);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Offer> retrieveOffersManager() {
		// TODO Auto-generated method stub
		List<Offer> list = new ArrayList<>();
		String sql = "select * from item_offers";
		Offer o = new Offer();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				o.setItem_id(rs.getInt("item_id"));
				o.setUser_id(rs.getInt("user_id"));
				o.setOffer(rs.getInt("offer"));
				
				list.add(o);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Offer retrieveOffersById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from item_offers where offer_id = ?";
		Offer o = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			o = new Offer();
			o.setOffer_id(rs.getInt("offer_id"));
			o.setItem_id(rs.getInt("item_id"));
			o.setUser_id(rs.getInt("user_id"));
			o.setOffer(rs.getInt("offer"));
			o.setStatus(OfferStatus.valueOf(rs.getString("status")));
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
			e.printStackTrace();
			
		} 
		return o;
	}

	@Override
	public List<Offer> retrieveOffersByItemId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOffer(Offer o) {
		// TODO Auto-generated method stub
		String sql = "delete from item_offers where offer_id NOT IN (?) and item_id = ?;";
		String sql2 = "update item_offers set status = CAST('ACCEPT' as accrej)";
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			PreparedStatement ps2 = c.prepareStatement(sql2);
			
			ps.setInt(1, o.getOffer_id());
			ps.setInt(2, o.getItem_id());
			
			
			ps.executeUpdate();
			ps2.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
