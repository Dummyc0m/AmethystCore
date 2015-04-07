package com.dummyc0m.amethystutil;

import com.dummyc0m.amethystutil.framework.inventory.InventoryListener;
import com.dummyc0m.amethystutil.framework.item.AUItemData;
import com.dummyc0m.amethystutil.framework.item.AUItemHandler;
import com.dummyc0m.amethystutil.framework.item.ItemListener;
import com.dummyc0m.amethystutil.test.Compass;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * com.dummyc0m.amethystutil
 * Created by Dummyc0m on 3/13/15.
 */
public class AmethystUtil extends JavaPlugin{
    private static AmethystUtil AMETHYSTUTIL;
    private Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        AMETHYSTUTIL = this;
        logger.info("Registering Listeners");
        this.getServer().getPluginManager().registerEvents(new ItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
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
        if(command.getName().equalsIgnoreCase("compass")){
            if(sender instanceof Player){
                Compass compass = new Compass(new AUItemData(Material.COMPASS), "AmethystUtilities", "amethyst:navigator");
                AUItemHandler.getInstance().registerItem(compass);
                ((Player) sender).setItemInHand(compass.getItemStack());
                return true;
            }
        }
        return false;
    }

    public static AmethystUtil getInstance(){
        return AMETHYSTUTIL;
    }
}