package me.GamingCuber.TPAPlugin.Listeners;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import me.GamingCuber.TPAPlugin.commands.TPASend;

public class CheckerForInventory implements InventoryHolder{
	

	public CheckerForInventory(me.GamingCuber.TPAPlugin.Main main) {
		
	}

	public CheckerForInventory(TPASend tpaSend) {
		
	}

	@Override
	public Inventory getInventory() {
		return null;
	}
	
}
