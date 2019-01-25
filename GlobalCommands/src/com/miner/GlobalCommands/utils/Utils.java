package com.miner.GlobalCommands.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Utils {

	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static void tell(CommandSender toWhom, String message) {
        toWhom.sendMessage(chat(message));
    }
	
}
