package com.miner.GlobalCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.miner.GlobalCommands.Main;
import com.miner.GlobalCommands.configs.SpawnConfig;
import com.miner.GlobalCommands.utils.Utils;

public class Spawn implements CommandExecutor {

	public Main plugin;
	
	private Location spawnLoc;
	
	
	public Spawn(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("spawn").setExecutor(this);
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("[GlobalCommands]Only players can use this command");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("globalcommands.spawn") || p.isOp()) {
			Utils.tell(p, "&bTeleporting to Spawn!");
			SpawnConfig config = new SpawnConfig();
			spawnLoc = config.loadConfig();
			p.teleport(spawnLoc);
			return true;

		} else {
			Utils.tell(p, ChatColor.DARK_RED + "You do not have permission to use this!");
		}
		
		
		return false;
	}

}
