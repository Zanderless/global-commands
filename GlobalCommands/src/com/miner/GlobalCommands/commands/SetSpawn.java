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

public class SetSpawn implements CommandExecutor{

	public Main plugin;

	public SetSpawn(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("setspawn").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("[GlobalCommands]Only players can use this command");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("globalcommands.setspawn") || p.isOp()) {
			Location loc = p.getLocation();
			
			SpawnConfig config = new SpawnConfig();
			
			config.saveConfig(loc);
			
			Utils.tell(p, "&bSpawn set!");

		} else {
			Utils.tell(p, ChatColor.DARK_RED + "You do not have permission to use this!");
		}
		
		
		return false;
	}
	
}
