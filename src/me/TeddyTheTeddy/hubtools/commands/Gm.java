package me.TeddyTheTeddy.hubtools.commands;

import me.TeddyTheTeddy.hubtools.HubTools;
import me.TeddyTheTeddy.hubtools.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm implements CommandExecutor{

	//Specifying Main File And Util File
	public static HubTools pl;
	
	//Boolean To Register Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player send = (Player) sender;
		if(sender.hasPermission(new Permissions().canGM) || sender.isOp()){
			//Command Label
			if(commandLabel.equalsIgnoreCase("gm")){
				
				
				if(send.getGameMode() == GameMode.ADVENTURE){
					send.setGameMode(GameMode.SURVIVAL);
					send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Survival");
				}
				else if(send.getGameMode() == GameMode.SURVIVAL){
					send.setGameMode(GameMode.CREATIVE);
					send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Creative");
				} else {
					send.setGameMode(GameMode.ADVENTURE);
					send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Adventure");					
				}
			}
			if(commandLabel.equalsIgnoreCase("gma")){
				send.setGameMode(GameMode.ADVENTURE);
				send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Adventure");				
			}
			if(commandLabel.equalsIgnoreCase("gms")){
				send.setGameMode(GameMode.SURVIVAL);
				send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Survival");			
			}
			if(commandLabel.equalsIgnoreCase("gmc")){
				send.setGameMode(GameMode.CREATIVE);
				send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + " You are now in " + ChatColor.GOLD + "Creative");			
			}
		}
		return false;
		
	}

}
