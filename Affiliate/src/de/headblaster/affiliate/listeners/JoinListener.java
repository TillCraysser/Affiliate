package de.headblaster.affiliate.listeners;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.headblaster.affiliate.mysql.MySQL;
import de.headblaster.affiliate.mysql.PlayerMySQL;

public class JoinListener implements Listener {

	public MySQL mysql = new MySQL();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		try {
			if (!mysql.inTable(e.getPlayer())) {

				PreparedStatement ps = mysql.getConnection()
						.prepareStatement("INSERT INTO Affiliate (username,uuid,code) VALUES (?,?,?)");
				ps.setString(1, p.getName());
				ps.setString(2, p.getUniqueId().toString());
				ps.setString(3, createCode(p));
				ps.executeUpdate();

				p.sendMessage("§2Da du das Erste mal auf dem Server bist, bekommst du einen Affiliate Code");
				p.sendMessage("§aEr lautet: " + PlayerMySQL.getCode(p));

			} else {

			}
		} catch (SQLException e1) {
			e.getPlayer().sendMessage("§cEin Fehler ist aufgetreten");
			e1.printStackTrace();
		}

	}

	public String createCode(Player p) {

		String uuid = p.getUniqueId().toString();
		uuid = uuid.substring(1, 10);
		uuid = uuid.replace("-", "");

		return uuid;

	}

}
