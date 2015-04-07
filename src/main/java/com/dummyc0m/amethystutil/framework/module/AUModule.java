package com.dummyc0m.amethystutil.framework.module;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.dummyc0m.amethystutil.framework.module
 * Created by Dummyc0m on 4/1/15.
 */
public class AUModule {
    private List<Player> playerList = new ArrayList<Player>();
    private List<String> permissions = new ArrayList<String>();

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

    public void onLogin(Player player){

    }

    public void onLogoff(Player player){

    }

}
