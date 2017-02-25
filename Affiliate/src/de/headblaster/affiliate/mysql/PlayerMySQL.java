package de.headblaster.affiliate.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class PlayerMySQL {

	public static MySQL mysql = new MySQL();

	public static String getCode(Player p) {

		try {
			PreparedStatement ps = mysql.getConnection()
					.prepareStatement("SELECT * FROM Affiliate WHERE uuid='" + p.getUniqueId().toString() + "'");
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			rs.last();
			return rs.getString("code");

		} catch (SQLException e) {
			e.printStackTrace();
			return "§cKein Code vorhanden";
		}

	}

	public static String getPlayer(String code) throws SQLException {

		PreparedStatement ps = mysql.getConnection()
				.prepareStatement("SELECT * FROM Affiliate WHERE code='" + code + "'");
		ps.executeQuery();
		ResultSet rs = ps.getResultSet();
		rs.last();

		return rs.getString("username");

	}

	public static String getUUID(String code) throws SQLException {

		PreparedStatement ps = mysql.getConnection()
				.prepareStatement("SELECT * FROM Affiliate WHERE code='" + code + "'");
		ps.executeQuery();
		ResultSet rs = ps.getResultSet();
		rs.last();

		return rs.getString("uuid");

	}

}
