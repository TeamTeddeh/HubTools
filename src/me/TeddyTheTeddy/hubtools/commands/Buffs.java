package me.TeddyTheTeddy.hubtools.commands;

import me.TeddyTheTeddy.hubtools.HubTools;
import me.TeddyTheTeddy.hubtools.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Buffs implements CommandExecutor{

	//Specifying Main File And Util File
	public static HubTools pl;
	
	//BuffCount Integer
	int buffRunCount = 0;
	
	//Prefix
	
	//Boolean To Register Command
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Command Label
		if(commandLabel.equalsIgnoreCase("buffs")){
			
			if(sender.hasPermission(new Permissions().canGiveBuffs) || sender.isOp()){
				Server server = Bukkit.getServer();
        		if(args.length == 0){
        			Player giver = (Player) sender;
        			Location LocationGiver = giver.getLocation();
        			server.broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.AQUA + " You Were Given Buffs Thanks To " + ChatColor.WHITE + giver.getName());
        			giver.playEffect(LocationGiver, Effect.SMOKE, 10);
        			for(Player potion : Bukkit.getOnlinePlayers()){
        				Player reciever = (Player) potion.getPlayer();
        				Location Location = reciever.getLocation();
        				
        				reciever.playSound(Location, Sound.LEVEL_UP, 10.0F, 10.0F);
        				reciever.playEffect(Location, Effect.MOBSPAWNER_FLAMES, 1);
        				reciever.playEffect(Location, Effect.POTION_BREAK, 1);
        				reciever.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 4), true);
        				reciever.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 2), true);
        				reciever.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0), true);
        			}
        			buffRunCount++;
        		}
        		else if(args.length == 1){
        			Player comSender = (Player) sender;
        			if(args[0].equalsIgnoreCase("stats")){
            			comSender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.GOLD + " The Command /Buffs Has Been Run " + ChatColor.BOLD + ChatColor.WHITE + buffRunCount + ChatColor.RESET + ChatColor.GOLD + " Time(s)");
            			comSender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.GOLD + " Since The Last Server Reload");          				
        			}
        			else {
            			comSender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.AQUA + " Invalid Command!");          				
        			}
        			
        		}
        		else {
        			Player comSender = (Player) sender;
        			
        			comSender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.AQUA + " Invalid Argument Count!");        			
        		}
        	}
        	else {
        		sender.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.DARK_AQUA + "HubTools" + ChatColor.DARK_PURPLE + "]" + ChatColor.GOLD + " You " + ChatColor.WHITE + sender.getName() + ChatColor.GOLD + " do not have permission to run this command!");
        	}
			
		}
		
		return false;
		
	}

}
