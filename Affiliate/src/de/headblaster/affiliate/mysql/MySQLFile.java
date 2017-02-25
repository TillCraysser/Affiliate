package de.headblaster.affiliate.mysql;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQLFile {

	public MySQL my = new MySQL();
	
	public static File file = new File("plugins/Affiliate/mysql.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void setStandard() {
		
		cfg.addDefault("host", "localhost");
		cfg.addDefault("username", "abcdefg");
		cfg.addDefault("password", "1234");
		cfg.addDefault("port", "3306");
		cfg.addDefault("database", "dev");
		
		cfg.options().copyDefaults(true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setData() {
		
		MySQL.host = cfg.getString("host");
		MySQL.username = cfg.getString("username");
		MySQL.password = cfg.getString("password");
		MySQL.port = cfg.getString("port");
		MySQL.database = cfg.getString("database");
		
	}
	
}
