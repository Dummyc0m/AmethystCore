package com.dummyc0m.amethystutil.framework.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * com.dummyc0m.amethystutil.framework.inventory
 * Created by Dummyc0m on 3/16/15.
 */
public class AUMenuHolder implements InventoryHolder {
    private final AUMenu menu;
    private final HumanEntity player;

    public AUMenuHolder(AUMenu menu, HumanEntity player){
        this.menu = menu;
        this.player = player;
    }

    public AUMenu getMenu(){
        return menu;
    }

    public HumanEntity getPlayer(){
        return player;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
