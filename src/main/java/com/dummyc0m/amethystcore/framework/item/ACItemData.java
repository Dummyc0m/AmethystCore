package com.dummyc0m.amethystcore.framework.item;

import com.dummyc0m.amethystcore.util.ACFormat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * com.dummyc0m.amethystcore.framework.item
 * Created by Dummyc0m on 4/1/15.
 */
public class ACItemData {
    private final boolean clickable;
    private final boolean interactable;
    private final boolean inventoryInteractable;
    private final boolean droppable;
    private final boolean consumable;
    private final boolean transformable;
    private final int amount;

    private final Material material;
    private final short damage;
    private final List<String> lores;
    private ItemStack itemInstance;

    private String module;
    private String identifier;

    public ACItemData() {
        this(Material.AIR);
    }

    public ACItemData(Material material) {
        this(material, (short) 0, 1, new ArrayList<>());
    }

    public ACItemData(Material material, short damage, int amount, List<String> lores) {
        this(material, damage, amount, lores, true, true, false, false, false, false);
    }

    /**
     * @param transformable true if the player is able to pick up this item.
     */
    public ACItemData(Material material, short damage, int amount, boolean clickable, boolean interactable, boolean inventoryInteractable, boolean droppable, boolean consumable, boolean transformable) {
        this(material, damage, amount, new ArrayList<>(), clickable, interactable, inventoryInteractable, droppable, consumable, transformable);
    }

    /**
     * @param transformable true if the player is able to pick up this item.
     */
    public ACItemData(Material material, short damage, int amount, List<String> lores, boolean clickable, boolean interactable, boolean inventoryInteractable, boolean droppable, boolean consumable, boolean transformable) {
        this.clickable = clickable;
        this.interactable = interactable;
        this.inventoryInteractable = inventoryInteractable;
        this.droppable = droppable;
        this.consumable = consumable;
        this.transformable = transformable;
        this.amount = amount;
        this.material = material;
        this.damage = damage;
        this.lores = lores;

        lores.add(ACFormat.RESET + ACFormat.BLUE + ACFormat.ITALIC + this.module);
        lores.add("Hide:" + this.identifier);

        this.itemInstance = new ItemStack(this.material, this.amount, this.damage);
        ItemMeta itemMeta = this.itemInstance.getItemMeta();
        itemMeta.setLore(this.lores);
        this.itemInstance.setItemMeta(itemMeta);
    }

    public String getIdentifier() {
        return identifier;
    }

    protected void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    protected void setModule(String module) {
        this.module = module;
    }

    public ItemStack getItemStack(){
        return itemInstance.clone();
    }
}
