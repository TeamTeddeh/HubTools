package me.TeddyTheTeddy.hubtools.commands;


import me.TeddyTheTeddy.hubtools.HubTools;
import me.TeddyTheTeddy.hubtools.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Stun implements CommandExecutor{

	//Specifying Main File And Util File
	public static HubTools pl;
	
	//BuffCount Integer
	int amouStunnedPlayers = 0;
	
	//Prefix
	
	//Boolean To Register Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("Stun")){
			if(sender.hasPermission(new Permissions().canStun) || sender.isOp()){
				
				Player comSend = (Player) sender;
				
				if(args.length == 1){
					int pLength = 30 * 20;
					
					Player targetPlayer = comSend.getServer().getPlayer(args[0]);
					if(targetPlayer == comSend){
						comSend.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "You Can't Stun Yourself!");
					}
					else {
						targetPlayer.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "You Were Stunned By " + ChatColor.WHITE + comSend.getDisplayName() + ChatColor.RED + "!");
						targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, pLength, 255));
						targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, pLength, 0));
						targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, pLength, 255));
						targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, pLength, 255));
					}
				}
				else {
					sender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.RED + "Invalid Argument Ammount!");
				}
			}
			else{
				sender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "You Do Not Have Permission To Run This Command");
			}
		}
		
		return false;
		
	}

}
