package com.dummyc0m.amethystcore.framework.item;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * com.dummyc0m.amethystcore.framework.item
 * Created by Dummyc0m on 3/15/15.
 */
public abstract class ACItem {

    private final String module;
    private final String identifier;
    private ACItemData data;

    public ACItem() {
        this(new ACItemData(), "Amethyst", "amethyst:default");
    }

    public ACItem(ACItemData data, String module, String identifier) {
        this.data = data;
        this.module = module;
        this.identifier = identifier;
        this.data.setModule(module);
        this.data.setIdentifier(identifier);
    }

    /**
     * Called when a player interacts with an object or air using this item.
     * @param who The player.
     * @param action The action performed with the item.
     * @param clickedBlock The block clicked.
     * @param clickedFace The block face clicked.
     * @return <p>True if the event is canceled.</p>
     * <p>This event will fire as cancelled if the vanilla behavior is to do nothing (e.g interacting with air)</p>
     */
    public boolean onInteract(Player who, Action action, Block clickedBlock, BlockFace clickedFace){
        return data.isClickable();
    }

    /**
     * Called when a player interacts with an entity using this item.
     * @param who The player.
     * @param clickedEntity The entity clicked.
     * @param position The location of the click.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onEntityInteract(Player who, Entity clickedEntity, Vector position){
        return data.isInteractable();
    }

    /**
     * Called when a player picks up this item.
     * @param who The player.
     * @param remaining The amount of item (if any) remaining on the ground.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onPickUp(Player who, int remaining){
        return ! data.isTransformable();
    }

    /**
     * Called when a player drops this item.
     * @param who The player.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onDrop(Player who){
        return ! data.isDroppable();
    }

    /**
     * Called when a player selects this item.
     * @param who The player.
     * @param previous The previously selected item slot.
     * @param current The currently selected item slot.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onSelected(Player who, int previous, int current){
        return false;
    }

    /**
     * Called when a player consumes this item.
     * @param who The player.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onConsume(Player who){
        return data.isConsumable();
    }

    /**
     * Called when a player breaks this item.
     * @param who The player.
     */
    public void onBreak(Player who){ }

    public ItemStack getItemStack(){
        return this.data.getItemStack();
    }

    public ACItemData getData() {
        return this.data;
    }

    public void setData(ACItemData data) {
        this.data = data;
    }

    public String getModule() {
        return module;
    }

    public String getIdentifier() {
        return identifier;
    }

    /**
     * Called when a player clicks this item in an AUMenu.
     * @return The item to be replaced in the player's hand.
     */
    public boolean onInventoryInteract(HumanEntity humanEntity, InventoryType.SlotType type, int slot, ClickType click, ItemStack item){
        return ! this.data.isInventoryInteractable();
    }

}
