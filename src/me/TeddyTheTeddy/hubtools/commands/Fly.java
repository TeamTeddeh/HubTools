package me.TeddyTheTeddy.hubtools.commands;

import me.TeddyTheTeddy.hubtools.HubTools;
import me.TeddyTheTeddy.hubtools.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{

	//Specifying Main File And Util File
	public static HubTools pl;
	
	//Boolean To Register Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("fly")  ||  commandLabel.equalsIgnoreCase("f")){
			Player send = (Player) sender;
			if(sender.hasPermission(new Permissions().canFly) || sender.isOp()){
				if(send.getAllowFlight() == true){
					send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.RED + " Your Fly Has Been Disabled");
    				send.setFlying(false);
    				send.setAllowFlight(false);					
				}else {
					send.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.GREEN + " Your Fly Has Been Enabled");
    				send.setAllowFlight(true);						
				}
			}
		}
		
		return false;
	}

}
