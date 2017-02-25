package de.headblaster.affiliate;

import org.bukkit.plugin.java.JavaPlugin;

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
		
	}
	
	@Override
	public void onDisable() {
	
	}
	
	public static Affiliate getInstance() {
		
		return Affiliate.getPlugin(Affiliate.class);
		
	}
	
}
