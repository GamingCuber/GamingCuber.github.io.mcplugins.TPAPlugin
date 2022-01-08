package me.GamingCuber.TPAPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.GamingCuber.TPAPlugin.Main;

public class ClickEventListener implements Listener{
	private Main plugin;
	
		public ClickEventListener(Main plugin) {
			this.plugin = plugin;
			Bukkit.getPluginManager().registerEvents(this, plugin);
		}
		
		@EventHandler
		public void onClick(InventoryClickEvent e, EntityDamageEvent event) {
			
			Player clicker = this.plugin.Receiver;
			World w = clicker.getWorld();
			if (e.getInventory().getHolder() instanceof CheckerForInventory) {
				e.setCancelled(true);
				switch (e.getCurrentItem().getType()) {
				case LIME_STAINED_GLASS_PANE:
					this.plugin.Sender.teleport(clicker.getLocation());
					clicker.closeInventory();
				default: 
					clicker.closeInventory();
					break;
				}
				if (event.getEntity().equals(clicker) && e.getInventory().getHolder() instanceof CheckerForInventory) {
					event.setCancelled(true);
				}
			
			}
			if (!(e.getInventory().getHolder() instanceof CheckerForInventory)) {
				event.setCancelled(false);
			}
			
		}
}
