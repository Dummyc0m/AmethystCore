package com.dummyc0m.amethystcore.framework.module;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.dummyc0m.amethystcore.framework.module
 * Created by Dummyc0m on 4/1/15.
 */
public class ACModule {
    private List<Player> playerList = new ArrayList<Player>();
    private List<String> permissions;

    private PlayerInventory defaultInventory;
    private Inventory defaultEnderChest;
    private int defaultSlotHolding;

    private int defaultXP;
    private Location defaultSpawn;

    private String resourcePack;

    private String chatPrefix;
    private String chatSuffix;

    private String namePrefix;
    private String nameSuffix;

    private String tabListTop;
    private String tabListBottom;

    private String identifier;

    public ACModule(List<String> permissions, PlayerInventory defaultInventory, Inventory defaultEnderChest, int defaultSlotHolding, int defaultXP, Location defaultSpawn, String resourcePack, String chatPrefix, String chatSuffix, String namePrefix, String nameSuffix, String tabListTop, String tabListBottom, String identifier) {
        this.permissions = permissions;
        this.defaultInventory = defaultInventory;
        this.defaultEnderChest = defaultEnderChest;
        this.defaultSlotHolding = defaultSlotHolding;
        this.defaultXP = defaultXP;
        this.defaultSpawn = defaultSpawn;
        this.resourcePack = resourcePack;
        this.chatPrefix = chatPrefix;
        this.chatSuffix = chatSuffix;
        this.namePrefix = namePrefix;
        this.nameSuffix = nameSuffix;
        this.tabListTop = tabListTop;
        this.tabListBottom = tabListBottom;
        this.identifier = identifier;
    }

    public void onLogin(Player player){

    }

    public void onLogoff(Player player){

    }

    public String getIdentifier() {
        return identifier;
    }

}
