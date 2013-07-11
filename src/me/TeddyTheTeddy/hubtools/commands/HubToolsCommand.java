package me.TeddyTheTeddy.hubtools.commands;

import me.TeddyTheTeddy.hubtools.HubTools;
import me.TeddyTheTeddy.hubtools.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubToolsCommand implements CommandExecutor{

	//Specifying Main File And Util File
	public static HubTools pl;
	
	//Boolean To Register Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("hubtools")){
			Player send = (Player) sender;
			if(sender.hasPermission(new Permissions().hubToolsAdmin) || sender.isOp()){
				if(args.length == 0){
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.BLUE + "Please Do " + ChatColor.GOLD + "/hubtools help" + ChatColor.BLUE + " for plugin info and help");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");
				}else if(args[0].equalsIgnoreCase("help")){
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/HubTools Help" + ChatColor.BLUE + " - For This Text!");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/HubTools GMHelp" + ChatColor.BLUE + " - Help With Different Gamemode Commands");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/Buffs" + ChatColor.BLUE + " - Gives Buffs To Everyone On The Server");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/Stun (player)" + ChatColor.BLUE + " - Stuns The Selected Player");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/UnStun (player)" + ChatColor.BLUE + " - Removes The Stun Effect From The Selected Player" + ChatColor.DARK_RED +  " - WIP");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/Fly" + ChatColor.BLUE + " - Allows Someone To Toggle Fly");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");
				}else if(args[0].equalsIgnoreCase("gmhelp")){
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage("");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/GM" + ChatColor.BLUE + " - Toggles Your Gamemode Between, Adventure, Survival and Creative");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/GMA" + ChatColor.BLUE + " - Sets Your Gamemode To Adventure");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/GMS" + ChatColor.BLUE + " - Sets Your Gamemode To Survival");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "-" + ChatColor.GOLD + "/GMC" + ChatColor.BLUE + " - Sets Your Gamemode To Creative");
					send.sendMessage(ChatColor.LIGHT_PURPLE + "----------" + ChatColor.BLUE + "[" + ChatColor.DARK_RED + "HubTools Admin" + ChatColor.BLUE + "]" + ChatColor.LIGHT_PURPLE + "----------");					
				}
			}
		}
		
		return false;
	}

}
