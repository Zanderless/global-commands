package com.miner.GlobalCommands;

import org.bukkit.plugin.java.JavaPlugin;

import com.miner.GlobalCommands.commands.Me;
import com.miner.GlobalCommands.commands.Ping;
import com.miner.GlobalCommands.commands.SetSpawn;
import com.miner.GlobalCommands.commands.Spawn;
import com.miner.GlobalCommands.listeners.JoinQuit;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new Ping(this);
		new Me(this);
		new JoinQuit(this);
		new Spawn(this);
		new SetSpawn(this);
	}
	
}
