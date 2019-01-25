package com.miner.GlobalCommands.configs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class SpawnConfig {

	public Location spawnLoc;
	
	public void saveConfig(Location loc) {
		
		YamlConfiguration yaml = new YamlConfiguration();
		
		if(loc == null) {
			yaml.createSection("Spawn");
        	yaml.createSection("Spawn.x");
        	yaml.createSection("Spawn.y");
        	yaml.createSection("Spawn.z");
        	yaml.createSection("Spawn.pitch");
        	yaml.createSection("Spawn.yaw");
        	yaml.createSection("Spawn.world");
		}
        yaml.set("Spawn.x", loc.getX());
        yaml.set("Spawn.y", loc.getY());
        yaml.set("Spawn.z", loc.getZ());
        yaml.set("Spawn.pitch", loc.getPitch());
        yaml.set("Spawn.yaw", loc.getYaw());
        yaml.set("Spawn.world", loc.getWorld().getName());
        spawnLoc = new Location(Bukkit.getServer().getWorld("world"), 0, 60, 0, 0, 0);
        try {
            yaml.save("plugins/GlobalCommands/Spawns.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	
	public Location loadConfig() {
		
		YamlConfiguration yaml = new YamlConfiguration();
		
		try {
			yaml.load("plugins/GlobalCommands/Spawns.yml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spawnLoc = new Location(Bukkit.getServer().getWorld(yaml.getString("Spawn.world")),
				(float)yaml.getDouble("Spawn.x"),
				(float)yaml.getDouble("Spawn.y"),
				(float)yaml.getDouble("Spawn.z"),
				(float)yaml.getDouble("Spawn.yaw"),
				(float)yaml.getDouble("Spawn.pitch"));
		
		return spawnLoc;
		
	}
	
}
