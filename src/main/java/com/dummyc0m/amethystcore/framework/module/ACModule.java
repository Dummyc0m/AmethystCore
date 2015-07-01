package com.dummyc0m.amethystcore.framework.module;

import com.dummyc0m.amethystcore.database.ACData;
import com.dummyc0m.amethystcore.framework.inventory.ACInventoryData;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.dummyc0m.amethystcore.framework.module
 * Created by Dummyc0m on 4/1/15.
 */
public abstract class ACModule {
    private List<Player> playerList = new ArrayList<>();
    private Map<String, Boolean> permissions;

    private ACInventoryData defaultInventory;
    private Inventory defaultEnderChest;

    private Location defaultSpawn;

    private boolean enablePack;
    private String resourcePack;

    private String chatFormat;

    private String tabListTop;
    private String tabListBottom;

    private String identifier;

    private ACModuleManager handler = ACModuleManager.getInstance();

    public ACModule(Map<String, Boolean> permissions, ACInventoryData defaultInventory, Inventory defaultEnderChest, Location defaultSpawn, String resourcePack, String chatFormat, String tabListTop, String tabListBottom, String identifier) {
        this.permissions = permissions;
        this.defaultInventory = defaultInventory;
        this.defaultEnderChest = defaultEnderChest;
        this.defaultSpawn = defaultSpawn;
        if (resourcePack != null) {
            this.enablePack = true;
            this.resourcePack = resourcePack;
        } else {
            this.enablePack = false;
        }
        this.chatFormat = chatFormat;
        this.tabListTop = tabListTop;
        this.tabListBottom = tabListBottom;
        this.identifier = identifier;
    }

    public void onJoin(Player player, ACData data) {
        this.handler.registerPlayer(player, this);
    }

    public String onLogoff(Player player, String quitMessage) {
        this.handler.deregisterPlayer(player);
        return quitMessage;
    }

    public String getChatFormat() {
        return this.chatFormat;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Map<String, Boolean> getPermissions() {
        return this.permissions;
    }
}
