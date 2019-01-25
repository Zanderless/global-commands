package com.miner.GlobalCommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.miner.GlobalCommands.Main;
import com.miner.GlobalCommands.utils.Utils;

public class Me implements CommandExecutor {
	public Main plugin;

	public Me(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("me").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("[GlobalCommands]Only players can use this command");
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("globalcommands.me")) {
			String text = "";
			if (args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					if (i == 0)
						text += args[i];
					else
						text += (" " + args[i]);
				}
					Bukkit.broadcastMessage(Utils.chat("&" + plugin.getConfig().getString("MeMessageColor") + p.getName() + " " + text));
			}
		} else {
			Utils.tell(p, ChatColor.DARK_RED + "You do not have permission to use this!");
		}

		return false;
	}
}
