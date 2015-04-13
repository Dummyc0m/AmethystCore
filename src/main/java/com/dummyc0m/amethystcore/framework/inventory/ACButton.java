package com.dummyc0m.amethystcore.framework.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystcore.framework.inventory
 * Created by Dummyc0m on 3/19/15.
 */
public abstract class ACButton {
    private ACButtonData data;

    public ACButton(ACButtonData data) {
        this.data = data;
    }

    public ItemStack onClick(ACMenu menu, HumanEntity humanEntity, ACMenu.ClickAction clickAction, ItemStack item) {
        return item;
    }

    public ItemStack onDrop(ACMenu menu, HumanEntity humanEntity, ACMenu.DropAction dropAction, ItemStack item) {
        return item;
    }

    public ItemStack onTransfer(ACMenu menu, HumanEntity humanEntity, ACMenu.TransferAction transferAction, ItemStack item) {
        return item;
    }

    public ItemStack getItem(){
        return this.data.getItemStack();
    }
}
