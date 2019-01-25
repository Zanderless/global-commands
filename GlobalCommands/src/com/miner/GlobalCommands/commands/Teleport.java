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

public class Teleport implements CommandExecutor{

public Main plugin;
	
	private Location spawnLoc;
	
	
	public Teleport(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("teleport").setExecutor(this);
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("[GlobalCommands]Only players can use this command");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("globalcommands.teleport") || p.isOp()) {
			
			

		} else {
			Utils.tell(p, ChatColor.DARK_RED + "You do not have permission to use this!");
		}
		
		
		return false;
	}
	
}
