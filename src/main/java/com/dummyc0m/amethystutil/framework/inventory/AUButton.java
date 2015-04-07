package com.dummyc0m.amethystutil.framework.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystutil.framework.inventory
 * Created by Dummyc0m on 3/19/15.
 */
public abstract class AUButton {
    private AUButtonData data;

    public AUButton(AUButtonData data) {
        this.data = data;
    }

    public ItemStack onClick(AUMenu menu, HumanEntity humanEntity, AUMenu.ClickAction clickAction, ItemStack item){
        return item;
    }

    public ItemStack onDrop(AUMenu menu, HumanEntity humanEntity, AUMenu.DropAction dropAction, ItemStack item){
        return item;
    }

    public ItemStack onTransfer(AUMenu menu, HumanEntity humanEntity, AUMenu.TransferAction transferAction, ItemStack item){
        return item;
    }

    public ItemStack getItem(){
        return this.data.getItemStack();
    }
}
