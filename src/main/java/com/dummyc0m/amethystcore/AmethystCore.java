package com.dummyc0m.amethystcore;

import com.dummyc0m.amethystcore.framework.inventory.InventoryListener;
import com.dummyc0m.amethystcore.framework.item.ACItemData;
import com.dummyc0m.amethystcore.framework.item.ACItemHandler;
import com.dummyc0m.amethystcore.framework.item.ItemListener;
import com.dummyc0m.amethystcore.framework.module.ModuleListener;
import com.dummyc0m.amethystcore.framework.permission.PermissionListener;
import com.dummyc0m.amethystcore.framework.region.RegionListener;
import com.dummyc0m.amethystcore.test.Compass;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * com.dummyc0m.amethystcore
 * Created by Dummyc0m on 3/13/15.
 */
public class AmethystCore extends JavaPlugin {
    private static AmethystCore AMETHYSTUTIL;
    private Logger LOGGER = this.getLogger();

    public static AmethystCore getInstance() {
        return AMETHYSTUTIL;
    }

    @Override
    public void onEnable() {
        AMETHYSTUTIL = this;
        LOGGER.info("Registering Listeners");
        this.getServer().getPluginManager().registerEvents(new ItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        this.getServer().getPluginManager().registerEvents(new ModuleListener(), this);
        this.getServer().getPluginManager().registerEvents(new PermissionListener(), this);
        this.getServer().getPluginManager().registerEvents(new RegionListener(), this);
        LOGGER.info("Enabled");
    }

    @Override
    public void onDisable() {
        LOGGER.info("Removing Listeners");
        HandlerList.unregisterAll(this);
        LOGGER.info("Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ("compass".equalsIgnoreCase(command.getName())) {
            if (sender instanceof Player) {
                Compass compass = new Compass(new ACItemData(Material.COMPASS), "AmethystUtilities", "amethyst:navigator");
                ACItemHandler.getInstance().registerItem(compass);
                ((Player) sender).setItemInHand(compass.getItemStack());
                return true;
            }
        }
        return false;
    }
}