package com.dummyc0m.amethystcore.framework.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * com.dummyc0m.amethystcore.framework.inventory
 * Created by Dummyc0m on 4/3/15.
 */
public class ACButtonData {
    private final boolean droppable;
    private final boolean transferable;

    private final Material material;
    private final int amount;
    private final short damage;

    private ItemMeta itemMeta;
    private ItemStack itemInstance;

    public ACButtonData() {
        this(Material.AIR);
    }

    public ACButtonData(Material material) {
        this(material, 1, (short) 0);
    }

    public ACButtonData(Material material, int amount, short damage) {
        this(material, amount, damage, false, false);
    }

    public ACButtonData(Material material, int amount, short damage, boolean droppable, boolean transferable) {
        this.droppable = droppable;
        this.transferable = transferable;
        this.material = material;
        this.amount = amount;
        this.damage = damage;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isTransferable() {
        return transferable;
    }

    public boolean isDroppable() {
        return droppable;
    }

    public ItemStack getItemStack(){
        if(this.itemInstance == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
            if(this.itemMeta == null){
                this.itemMeta = this.itemInstance.getItemMeta();
            }
        }
        return itemInstance.clone();
    }

    public ItemMeta getItemMeta(){
        if(this.itemMeta == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
            this.itemMeta = this.itemInstance.getItemMeta();
            this.itemInstance.setItemMeta(this.itemMeta);
        }
        return this.itemMeta.clone();
    }

    public void setItemMeta(ItemMeta itemMeta){
        this.itemMeta = itemMeta;
        if(this.itemInstance == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
        }
        this.itemInstance.setItemMeta(this.itemMeta);
    }
}
