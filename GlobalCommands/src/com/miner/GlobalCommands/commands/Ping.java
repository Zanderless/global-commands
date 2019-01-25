package com.miner.GlobalCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.miner.GlobalCommands.Main;
import com.miner.GlobalCommands.utils.Utils;

public class Ping implements CommandExecutor{

	public Main plugin;
	
	public Ping(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("ping").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage("[GlobalCommands]Only players can use this command");
			return true;
		}

		Player p = (Player) sender;
		
		if(p.hasPermission("globalcommands.ping") || p.isOp()){
			Utils.tell(p, "Pong!");
		}
		else {
			Utils.tell(p, ChatColor.DARK_RED + "You do not have permission to use this!");
		}
		
		return false;
	}
	
	

}
