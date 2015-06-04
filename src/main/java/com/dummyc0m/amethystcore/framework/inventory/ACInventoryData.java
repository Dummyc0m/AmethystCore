package com.dummyc0m.amethystcore.framework.inventory;

import org.bukkit.inventory.ItemStack;

/**
 * Created by Dummyc0m on 5/25/15.
 */
public class ACInventoryData {
    private final ItemStack helmet;
    private final ItemStack chestplate;
    private final ItemStack leggings;
    private final ItemStack boots;

    private ItemStack[] contents;

    public ACInventoryData(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, ItemStack[] contents) {
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.contents = contents;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public ItemStack[] getContents() {
        return contents;
    }
}
