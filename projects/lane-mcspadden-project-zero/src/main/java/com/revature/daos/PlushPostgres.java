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
import com.revature.modelview.pages.CustomerPage;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlushPostgres implements PlushDAO {

	private static Logger log = LogManager.getLogger(PlushPostgres.class);

	@Override
	public AnimePlush createPlush(AnimePlush p) {
		// TODO Auto-generated method stub
		String sql = "insert into shopitems (item_name, item_desc, item_price, item_state) values (?,?,?, CAST(? AS STATUS)) returning item_id";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setInt(3, p.getPrice());
			ps.setString(4, p.getStatus().toString());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("item_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<AnimePlush> retrievePlush() {
		// TODO Auto-generated method stub
		String sql = "select * from shopitems;";
		List<AnimePlush> plush = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				AnimePlush p = new AnimePlush();
				p.setId(rs.getInt("item_id"));
				p.setName(rs.getString("item_name"));
				p.setDescription(rs.getString("item_desc"));
				p.setPrice(rs.getInt("item_price"));
				p.setStatus(rs.getString("item_state"));

				plush.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plush;
	}

	@Override
	public AnimePlush retrievePlushById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from shopitems where item_id = ?";
		AnimePlush p = null;
		try (Connection c = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			p = new AnimePlush();
			p.setId(rs.getInt("item_id"));
			p.setName(rs.getString("item_name"));
			p.setDescription(rs.getString("item_desc"));
			p.setPrice(rs.getInt("item_price"));
			p.setStatus(rs.getString("item_state"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<AnimePlush> retrievePlushByUserId(int id) {
		// TODO Auto-generated method stub
		List<AnimePlush> tempArr = new ArrayList<>();

		String sql = "select s.item_id, s.item_name, s.item_desc, o.balance\r\n" + "from users u\r\n"
				+ "join user_items_owned o \r\n" + "on o.user_id = u.id\r\n" + "join shopitems s \r\n"
				+ "on o.item_id = s.item_id where u.id = ?;";

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AnimePlush temp = new AnimePlush();
				temp.setId(rs.getInt("item_id"));
				temp.setName(rs.getString("item_name"));
				temp.setDescription(rs.getString("item_desc"));
				temp.setPrice(rs.getInt("balance"));
				tempArr.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempArr;
	}

	@Override
	public boolean updatePlush(AnimePlush p) {
		// TODO Auto-generated method stub
		String sql = "update shopitems set item_state = CAST(? as status), item_price = ? where item_id = ?;";
		String sql2 = "update user_items_owned set balance = ? where item_id = ?;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			PreparedStatement ps2 = c.prepareStatement(sql2);

			ps.setString(1, p.getStatus().toString());
			ps.setInt(2, p.getPrice());
			ps.setInt(3, p.getId());

			ps2.setInt(1, p.getPrice());
			ps2.setInt(2, p.getId());

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

	public boolean removePlush(int id) {
		String sql = "delete from shopitems where item_id = ?";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
			e.printStackTrace();
		}

		return false;

	}

}
