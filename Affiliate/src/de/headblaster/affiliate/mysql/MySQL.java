package de.headblaster.affiliate.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MySQL {

	public static String host,
					username,
					password,
					database,
					port;
	
	public static Connection con;
	
	public void connect() {
		
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,username,password);
			Bukkit.getConsoleSender().sendMessage("§aErfolgreich mit MySQL verbunden.");
			
		} catch(SQLException e) {
			
			Bukkit.getConsoleSender().sendMessage("§cKonnte sich nicht mit MySQL verbinden.");
			e.printStackTrace();
			
		}
		
	}
	
	public void update(String qry) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(qry);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void disconnect() throws SQLException {
		
		if(con.isClosed() == false) {
			
			con.close();
			
		}
		
	}

	public boolean inTable(Player p) throws SQLException {

			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM Affiliate WHERE uuid='"  + p.getUniqueId().toString() +  "'");
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			
			if(rs.next()) {
				
				return true;
				
			} else 
			
			return false;
		
		
	}
	
}
