package me.GamingCuber.TPAPlugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.GamingCuber.TPAPlugin.Listeners.CheckerForInventory;
import me.GamingCuber.TPAPlugin.Listeners.ClickEventListener;
import me.GamingCuber.TPAPlugin.commands.TPASend;

public class Main extends JavaPlugin {
	
	public Player Receiver;
	public Player Sender;
	
	@Override
	public void onEnable() {
		new TPASend(this);
		new CheckerForInventory(this);
		new ClickEventListener(this);
	}
}
