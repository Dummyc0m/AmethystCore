package com.dummyc0m.amethystutil.framework.item;

import com.dummyc0m.amethystutil.util.AUFormat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * com.dummyc0m.amethystutil.framework.item
 * Created by Dummyc0m on 4/1/15.
 */
public class AUItemData {
    private final boolean clickable;
    private final boolean interactable;
    private final boolean inventoryInteractable;
    private final boolean droppable;
    private final boolean consumable;
    private final boolean transformable;
    private final int amount;

    private final Material material;
    private final short damage;
    private ItemMeta itemMeta;
    private ItemStack itemInstance;

    private String module;
    private String identifier;

    public AUItemData(){
        this(Material.AIR);
    }
    public AUItemData(Material material) {
        this(material, true, true, false, false, false, false);
    }

    public AUItemData(Material material, short damage, int amount) {
        this(material, damage, amount, true, true, false, false, false, false);
    }

    /**
     * @param transformable true if the player is able to pick up this item.
     */
    private AUItemData(Material material, boolean clickable, boolean interactable, boolean inventoryInteractable, boolean droppable, boolean consumable, boolean transformable) {
        this(material, (short) 0, 1, clickable, interactable, inventoryInteractable, droppable, consumable, transformable);
    }

    /**
     * @param transformable true if the player is able to pick up this item.
     */
    public AUItemData(Material material, short damage, int amount, boolean clickable, boolean interactable, boolean inventoryInteractable, boolean droppable, boolean consumable, boolean transformable) {
        this.clickable = clickable;
        this.interactable = interactable;
        this.inventoryInteractable = inventoryInteractable;
        this.droppable = droppable;
        this.consumable = consumable;
        this.transformable = transformable;
        this.amount = amount;
        this.material = material;
        this.damage = damage;
    }

    public String getIdentifier() {
        return identifier;
    }

    public boolean isClickable() {
        return clickable;
    }

    public boolean isInteractable(){
        return interactable;
    }

    public boolean isInventoryInteractable() {
        return inventoryInteractable;
    }

    public boolean isDroppable() {
        return droppable;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public boolean isTransformable() {
        return transformable;
    }

    public String getModule() {
        return module;
    }

    public ItemStack getItemStack(){
        if(this.itemInstance == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
            if(this.itemMeta == null){
                this.itemMeta = this.itemInstance.getItemMeta();
            }
            List<String> lores = this.itemMeta.getLore();
            if(lores == null){
                lores = new ArrayList<String>();
            }
            ItemMeta meta = this.itemMeta.clone();
            lores.add(AUFormat.RESET + AUFormat.BLUE + AUFormat.ITALIC + this.module);
            lores.add(AUFormat.RESET + AUFormat.DARK_GRAY + this.identifier);
            meta.setLore(lores);
            this.itemInstance.setItemMeta(meta);
        }
        return itemInstance.clone();
    }

    public ItemMeta getItemMeta(){
        if(this.itemMeta == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
            this.itemMeta = this.itemInstance.getItemMeta();
            List<String> lores = this.itemMeta.getLore();
            if(lores == null){
                lores = new ArrayList<String>();
            }
            ItemMeta meta = this.itemMeta.clone();
            lores.add(AUFormat.RESET + AUFormat.BLUE + AUFormat.ITALIC + this.module);
            lores.add(AUFormat.RESET + AUFormat.DARK_GRAY + this.identifier);
            meta.setLore(lores);
            this.itemInstance.setItemMeta(meta);
        }
        return this.itemMeta.clone();
    }

    public void setItemMeta(ItemMeta itemMeta){
        this.itemMeta = itemMeta;
        if(this.itemInstance == null){
            this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
        }
        List<String> lores = this.itemMeta.getLore();
        if(lores == null){
            lores = new ArrayList<String>();
        }
        ItemMeta meta = this.itemMeta.clone();
        lores.add(AUFormat.RESET + AUFormat.BLUE + AUFormat.ITALIC + this.module);
        lores.add(AUFormat.RESET + AUFormat.DARK_GRAY + this.identifier);
        meta.setLore(lores);
        this.itemInstance.setItemMeta(meta);
    }

    protected void setModule(String module) {
        this.module = module;
    }

    protected void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
