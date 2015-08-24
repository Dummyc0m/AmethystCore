package com.dummyc0m.amethystcore;

import com.dummyc0m.amethystcore.config.ACConfig;
import com.dummyc0m.amethystcore.inventory.InventoryListener;
import com.dummyc0m.amethystcore.item.CoreItem;
import com.dummyc0m.amethystcore.item.ItemListener;
import com.dummyc0m.amethystcore.npc.CoreNPC;
import com.dummyc0m.amethystcore.npc.NPCListener;
import com.dummyc0m.amethystcore.permission.CorePermission;
import com.dummyc0m.amethystcore.permission.PermissionGroups;
import com.dummyc0m.amethystcore.region.CoreRegion;
import com.dummyc0m.amethystcore.region.RegionListener;
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
    private String version = "1.0-SNAPSHOT For 1.8.8";

    private CoreItem itemManager;

    private CorePermission permissionManager;
    private PermissionGroups permissionGroups;
    private ACConfig permissionGroupsConfig;

    private CoreRegion regionManager;

    private CoreNPC npcManager;
    private ACConfig coreNPCConfig;

    private Logger logger = this.getLogger();

    public static AmethystCore getInstance() {
        return AMETHYSTCORE;
    }

    public CoreItem getItemManager() {
        return itemManager;
    }

    public CorePermission getPermissionManager() {
        return permissionManager;
    }

    public CoreRegion getRegionManager() {
        return regionManager;
    }

    public PermissionGroups getPermissionGroups() {
        return permissionGroups;
    }

    public CoreNPC getNpcManager() {
        return npcManager;
    }

    @Override
    public void onEnable() {
        AMETHYSTCORE = this;

        logger.info("Loading Configurations");
        //NPC File
        coreNPCConfig = new ACConfig("CoreNPC.json", CoreNPC.class);
        npcManager = (CoreNPC) coreNPCConfig.getSettings();
        assert npcManager != null;
        //Permission File
        permissionGroupsConfig = new ACConfig("PermissionGroups.json", PermissionGroups.class);
        permissionGroups = (PermissionGroups) permissionGroupsConfig.getSettings();
        assert permissionGroups != null;

        logger.info("Loading Cores");
        itemManager = new CoreItem();
        permissionManager = new CorePermission(permissionGroups);
        regionManager = new CoreRegion();

        logger.info("Registering Listeners");
        this.getServer().getPluginManager().registerEvents(new ItemListener(itemManager), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        this.getServer().getPluginManager().registerEvents(new NPCListener(this, npcManager), this);
        this.getServer().getPluginManager().registerEvents(new RegionListener(regionManager), this);

        logger.info("Enabled");
    }

    @Override
    public void onDisable() {
        logger.info("Saving Configurations");
        coreNPCConfig.save();
        permissionGroupsConfig.save();

        logger.info("Removing Listeners");
        HandlerList.unregisterAll(this);

        logger.info("Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ("amethystcore".equalsIgnoreCase(command.getName())) {
            sender.sendMessage("Running AmethystCore Ver." + version);
        }
        return false;
    }
}