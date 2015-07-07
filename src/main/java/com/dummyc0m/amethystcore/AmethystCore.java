package com.dummyc0m.amethystcore;

import com.dummyc0m.amethystcore.framework.inventory.InventoryListener;
import com.dummyc0m.amethystcore.framework.item.ACItemData;
import com.dummyc0m.amethystcore.framework.item.ACItemManager;
import com.dummyc0m.amethystcore.framework.item.ItemListener;
import com.dummyc0m.amethystcore.framework.permission.PermissionListener;
import com.dummyc0m.amethystcore.framework.region.RegionListener;
import com.dummyc0m.amethystcore.test.ItemCore;
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
    private static AmethystCore AMETHYSTCORE;
    private Logger logger = this.getLogger();
    private ItemCore itemCore;
    private String version = "SNAPSHOT 0.1 For 1.8.4";

    public static AmethystCore getInstance() {
        return AMETHYSTCORE;
    }

    @Override
    public void onEnable() {
        AMETHYSTCORE = this;
        logger.info("Registering Listeners");
        this.getServer().getPluginManager().registerEvents(new ItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        this.getServer().getPluginManager().registerEvents(new PermissionListener(), this);
        this.getServer().getPluginManager().registerEvents(new RegionListener(), this);
        logger.info("Registering Demo Item");
        this.itemCore = new ItemCore(new ACItemData(Material.COMPASS), "AmethystCore", "amethystcore:item_core");
        ACItemManager.getInstance().registerItem(itemCore);
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
            if (sender instanceof Player && sender.hasPermission("amethystcore.command.item_core")) {
                ((Player) sender).getInventory().addItem(this.itemCore.getItemStack());
                return true;
            }
        }
        return false;
    }
}