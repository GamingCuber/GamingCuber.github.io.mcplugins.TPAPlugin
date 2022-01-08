package me.GamingCuber.TPAPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.GamingCuber.TPAPlugin.Main;
import me.GamingCuber.TPAPlugin.Listeners.CheckerForInventory;
import net.md_5.bungee.api.ChatColor;

public class TPASend implements CommandExecutor {
	private Main plugin;
	
		public TPASend(Main plugin) {
			this.plugin = plugin;
			plugin.getCommand("tp").setExecutor(this);
		}
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			Player Sender = this.plugin.Sender;
			this.plugin.Sender = (Player) sender;
			this.plugin.Receiver = Bukkit.getPlayer(args[0]);
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "You must put the name of a player.");
			} else if (args.length == 1) {
				try {
					Player Receiver1 = Bukkit.getPlayer(args[0]);
					Receiver1.sendMessage(ChatColor.GREEN + sender.getName() + " has sent a teleport request.");
				} catch (IllegalArgumentException e) {
					sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Please put the command in this format. /tp <playername>");
				} 
				Inventory AcceptRequest = Bukkit.createInventory(new CheckerForInventory(this), 9, "Accept Menu");
				
				ItemStack AcceptItem = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
				ItemStack DenyItem = new ItemStack(Material.RED_STAINED_GLASS_PANE);
				
				ItemMeta acceptitem_meta = AcceptItem.getItemMeta();
				acceptitem_meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Accept");
				ArrayList <String> acceptitem_lore = new ArrayList<>();
				acceptitem_lore.add(ChatColor.GREEN + "Click this to Accept!");
				acceptitem_meta.setLore(acceptitem_lore);
				AcceptItem.setItemMeta(acceptitem_meta);
				
				ItemMeta denyitem_meta = DenyItem.getItemMeta();
				denyitem_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Deny");
				ArrayList <String> denyitem_lore = new ArrayList<>();
				denyitem_lore.add(ChatColor.RED + "Click this to Deny");
				denyitem_meta.setLore(denyitem_lore);
				DenyItem.setItemMeta(denyitem_meta);
				
				for (int i = 0; i < 4; i++) {
					AcceptRequest.setItem(i, AcceptItem);
				} for (int i = 5; i < 9; i++) {
					AcceptRequest.setItem(i, DenyItem);
				} AcceptRequest.setItem(4, new ItemStack(Material.BLACK_CONCRETE));
				
				this.plugin.Receiver.openInventory(AcceptRequest);
				
			} 
			
			
			
			
			
			return false;
		}
}
