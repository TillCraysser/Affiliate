package de.headblaster.affiliate;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.headblaster.affiliate.listeners.JoinListener;
import de.headblaster.affiliate.mysql.MySQL;
import de.headblaster.affiliate.mysql.MySQLFile;

public class Affiliate extends JavaPlugin{

	public MySQL mysql = new MySQL();
	public MySQLFile file = new MySQLFile();
	
	@Override
	public void onLoad() {
		
	
		
	}
	
	@Override
	public void onEnable() {
	
		file.setStandard();
		file.setData();

		mysql.connect();
		
		mysql.update("CREATE TABLE IF NOT EXISTS Affiliate (username VARCHAR(20),uuid VARCHAR(100),code VARCHAR(100))");
		
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		
	}
	
	@Override
	public void onDisable() {
	
		try {
			mysql.disconnect();
		} catch (SQLException e) {
			
		}
		
	}
	
	public static Affiliate getInstance() {
		
		return Affiliate.getPlugin(Affiliate.class);
		
	}
	
}
