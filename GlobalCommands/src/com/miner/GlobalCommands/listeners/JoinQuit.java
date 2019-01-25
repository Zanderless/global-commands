package com.miner.GlobalCommands.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.miner.GlobalCommands.Main;
import com.miner.GlobalCommands.utils.Utils;

public class JoinQuit implements Listener {

	private Main plugin;

	public JoinQuit(Main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!plugin.getConfig().getString("firstJoinMessage").equals("none")){
			if (!p.hasPlayedBefore()) {
				e.setJoinMessage(
						Utils.chat(plugin.getConfig().getString("firstJoinMessage").replace("{PLAYER}", p.getName())));
			} else {
				e.setJoinMessage(
						Utils.chat(plugin.getConfig().getString("joinMessage").replace("{PLAYER}", p.getName())));
			}
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (!plugin.getConfig().getString("firstJoinMessage").equals("none"))
			e.setQuitMessage(
					Utils.chat(plugin.getConfig().getString("leaveMessage").replace("{PLAYER}", p.getName())));

	}

}
