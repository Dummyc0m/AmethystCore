package com.dummyc0m.amethystcore;

import com.dummyc0m.amethystcore.framework.inventory.InventoryListener;
import com.dummyc0m.amethystcore.framework.item.ACItemManager;
import com.dummyc0m.amethystcore.framework.item.ItemListener;
import com.dummyc0m.amethystcore.framework.permission.ACPerms;
import com.dummyc0m.amethystcore.framework.permission.PermissionListener;
import com.dummyc0m.amethystcore.framework.region.ACRegionManager;
import com.dummyc0m.amethystcore.framework.region.RegionListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * com.dummyc0m.amethystcore
 * Created by Dummyc0m on 3/13/15.
 */
public class AmethystCore extends JavaPlugin {
    private static AmethystCore AMETHYSTCORE;
    private ACItemManager itemManager;
    private ACPerms perms;
    private ACRegionManager regionManager;
    private Logger logger = this.getLogger();
    private String version = "1.0-SNAPSHOT For 1.8.7";

    public static AmethystCore getInstance() {
        return AMETHYSTCORE;
    }

    public ACItemManager getItemManager() {
        return itemManager;
    }

    public ACPerms getPerms() {
        return perms;
    }

    public ACRegionManager getRegionManager() {
        return regionManager;
    }

    @Override
    public void onEnable() {
        logger.info("Loading Configurations");
        //TODO configuration
        AMETHYSTCORE = this;
        itemManager = new ACItemManager();
        perms = new ACPerms();
        regionManager = new ACRegionManager();
        logger.info("Registering Listeners");
        this.getServer().getPluginManager().registerEvents(new ItemListener(itemManager), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        this.getServer().getPluginManager().registerEvents(new PermissionListener(), this);
        this.getServer().getPluginManager().registerEvents(new RegionListener(regionManager), this);
        logger.info("Enabled");
    }

    @Override
    public void onDisable() {
        logger.info("Removing Listeners");
        HandlerList.unregisterAll(this);
        logger.info("Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ("amethystcore".equalsIgnoreCase(command.getName())) {
            sender.sendMessage("Running AmethystCore Version." + version);
        }
        return false;
    }
}