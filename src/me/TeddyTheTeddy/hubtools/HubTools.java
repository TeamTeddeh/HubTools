package me.TeddyTheTeddy.hubtools;

import java.io.File;
import java.util.logging.Logger;

import me.TeddyTheTeddy.hubtools.Permissions;
import me.TeddyTheTeddy.hubtools.commands.Buffs;
import me.TeddyTheTeddy.hubtools.commands.Fly;
import me.TeddyTheTeddy.hubtools.commands.Gm;
import me.TeddyTheTeddy.hubtools.commands.HubToolsCommand;
import me.TeddyTheTeddy.hubtools.commands.Stun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HubTools extends JavaPlugin implements Listener{
	
	//Logger - Minecraft
	public final Logger mcLogger = Logger.getLogger("Minecraft");
	
	//Specifying Files
	public File configFile = new File(this.getDataFolder(), "config.yml");
	
	//Variables
	public Server server;
	
	//On Plugin Enable
	@Override
	public void onEnable(){
		
		//Getting Server Info
		server = getServer();
		for(Player p : server.getOnlinePlayers())
		
		
		//Turns on the Commands
		initializeCommands();
		
		//Config Files
		this.getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		//Permissions
		PluginManager pm = this.getServer().getPluginManager();
		pm.addPermission(new Permissions().HubToolsAdmin);
		pm.addPermission(new Permissions().canGiveBuffs);
		pm.addPermission(new Permissions().canStun);
		pm.addPermission(new Permissions().canUnstun);
		pm.addPermission(new Permissions().canGM);
		
		//Events
		pm.registerEvents(this, this);
		
		
		
	}
	
	//On Plugin Disable
	@Override
	public void onDisable(){
		
		
		
	}
	
	//Events
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(this.getConfig().getBoolean("backToHubItem")){
        	if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
        		if(p.getItemInHand().getType() == Material.NETHER_STAR){
        			World world = Bukkit.getWorld(getConfig().getString("hubWorld"));
        			Location spawn = new Location(world, getConfig().getInt("hubX"), getConfig().getInt("hubY")+5, getConfig().getInt("hubZ"));
        			
        			p.teleport(spawn);
            	
        			p.sendMessage("You are now at spawn");
        		}
        	}
		}
        if(this.getConfig().getBoolean("quickWarpItem")){
        	if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
        		if(p.getItemInHand().getType() == Material.COMPASS){
        			Inventory qw = Bukkit.createInventory(p, 9, ChatColor.BLACK + "Quick Warp");
           			qw.clear();
           			//ItemStacks For QW
        				ItemStack wb = new ItemStack(Material.COMMAND, 0);
        				ItemMeta wbMeta = wb.getItemMeta();
        				wbMeta.setDisplayName(ChatColor.DARK_AQUA + "Admin Hub");
        				wb.setItemMeta(wbMeta);
        			//End
        			
        			qw.setItem(4, wb);
        			p.openInventory(qw);
        			p.closeInventory();
        		}
        	}
        }
    }
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		if(this.getConfig().getBoolean("clearInventoryOnJoin")){
			Player p = event.getPlayer();
			p.getInventory().clear();
			
			

	        if(this.getConfig().getBoolean("backToHubItem")){
	        	ItemStack bth = new ItemStack(Material.NETHER_STAR, 1);    
    			ItemMeta bthMeta = bth.getItemMeta();
    			bthMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Back " + ChatColor.GREEN + "To " + ChatColor.BLUE + "Hub");
    			bth.setItemMeta(bthMeta);
    		
    			p.getInventory().setItem(8, bth);
	        }
	       if(this.getConfig().getBoolean("quickWarpItem")){
	    	   ItemStack qw = new ItemStack(Material.COMPASS, 1);
	    	   ItemMeta qwMeta = qw.getItemMeta();
	    	   qwMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Quick Warp");
	    	   qw.setItemMeta(qwMeta);
	    	   
	    	   p.getInventory().setItem(7, qw);
	       }
	       p.updateInventory();
		}
	}
	public void onInventoryOpen(InventoryOpenEvent event){
		Player p = (Player) event.getPlayer();
		if(p.openInventory(qw)){
			
		}
	}

	//Command Register
	public void initializeCommands(){

		
		if(this.getConfig().getBoolean("enableBuffs")){
			getCommand("Buffs").setExecutor(new Buffs());
		}
		if(this.getConfig().getBoolean("enableStun")){
			getCommand("Stun").setExecutor(new Stun());
		}
		if(this.getConfig().getBoolean("enableGM")){
			getCommand("Gm").setExecutor(new Gm());
		}
		if(this.getConfig().getBoolean("enableGMC")){
			getCommand("gmc").setExecutor(new Gm());
		}
		if(this.getConfig().getBoolean("enableGMA")){
			getCommand("gma").setExecutor(new Gm());
		}
		if(this.getConfig().getBoolean("enableGMA")){
			getCommand("gms").setExecutor(new Gm());
		}
		if(this.getConfig().getBoolean("enableFly")){
			getCommand("fly").setExecutor(new Fly());			
		}
			getCommand("hubtools").setExecutor(new HubToolsCommand());
		
	}
	
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("test")){
				Player p = (Player) sender;
			
	    	   ItemStack qw = new ItemStack(Material.COMPASS, 1);
	    	   ItemMeta qwMeta = qw.getItemMeta();
	    	   qwMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Quick Warp");
	    	   qw.setItemMeta(qwMeta);
	    	   
	    	   p.getInventory().addItem(qw);
		}
		
		return false;
	}
	
	
}
