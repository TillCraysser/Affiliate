package de.headblaster.affiliate.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

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
	
	public static Connection getConnection() {
		return con;
	}
	
}
