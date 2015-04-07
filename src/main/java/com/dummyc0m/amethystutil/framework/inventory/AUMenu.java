package com.dummyc0m.amethystutil.framework.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * com.dummyc0m.amethystutil.framework.inventory
 * Created by Dummyc0m on 3/15/15.
 */
public class AUMenu {
    private int size;
    private String title;
    private AUButton[] contents;

    private List<AUMenuHolder> viewers = new ArrayList<AUMenuHolder>();

    public AUMenu(int size, String title, AUButton[] contents){
        this.size = size;
        this.title = title;
        this.contents = contents;
    }

    public AUMenu(int size, String title){
        this.size = size;
        this.title = title;
    }

    /**
     * Called when a player opens this inventory.
     * @param inventory The inventory.
     * @param who The player.
     * @return <p>True if the event is canceled.</p>
     */
    public boolean onOpen(Inventory inventory, HumanEntity who){
        return false;
    }

    /**
     * Called when a player closes this inventory.
     * @param inventory The inventory.
     * @param who The player.
     */
    public void onClose(Inventory inventory, HumanEntity who){
        this.viewers.remove(inventory.getHolder());
    }

    /**
     * Called when a player clicks in this inventory.
     * @param inventory The inventory.
     * @param type Inventory slot type.
     * @param slot Inventory slot.
     * @param click Type of click.
     * @return <p>True if the event is canceled.</p>
     */
    public ItemStack onClick(Inventory inventory, InventoryType.SlotType type, int slot, ClickType click, ItemStack item, HumanEntity whoClicked){
        AUButton button = this.contents[slot];
        if(button != null){
            switch(click){
                case LEFT:
                    return button.onClick(this, whoClicked, ClickAction.LEFT, item);
                case RIGHT:
                    return button.onClick(this, whoClicked, ClickAction.RIGHT, item);
                case MIDDLE:
                    return button.onClick(this, whoClicked, ClickAction.MIDDLE, item);
                case DOUBLE_CLICK:
                    return button.onClick(this, whoClicked, ClickAction.DOUBLE, item);
                case WINDOW_BORDER_LEFT:
                    return button.onClick(this, whoClicked, ClickAction.BORDER_LEFT, item);
                case WINDOW_BORDER_RIGHT:
                    return button.onClick(this, whoClicked, ClickAction.BORDER_RIGHT, item);
                case SHIFT_LEFT:
                    return button.onTransfer(this, whoClicked, TransferAction.SHIFT_LEFT, item);
                case SHIFT_RIGHT:
                    return button.onTransfer(this, whoClicked, TransferAction.SHIFT_RIGHT, item);
                case NUMBER_KEY:
                    return button.onTransfer(this, whoClicked, TransferAction.NUMBER_KEY, item);
                case DROP:
                    return button.onDrop(this, whoClicked, DropAction.DROP, item);
                case CONTROL_DROP:
                    return button.onDrop(this, whoClicked, DropAction.DROP_STACK, item);
            }
        }
        return item;
    }


    public void display(Player player){
        AUMenuHolder holder = new AUMenuHolder(this, player);
        Inventory inventory = Bukkit.createInventory(holder, size, title);
        ItemStack[] itemStackList = new ItemStack[size];
        int i = 0;
        for(AUButton b : contents){
            if(b != null) itemStackList[i] = b.getItem();
            i++;
        }
        inventory.setContents(itemStackList);
        player.openInventory(inventory);
        this.viewers.add(holder);
    }

    public void setContents(AUButton[] items){
        this.contents = items;
    }

    public AUButton[] getContents(){
        return contents;
    }

    public List<AUMenuHolder> getViewers() {
        return viewers;
    }

    public enum ClickAction {
        LEFT, RIGHT, MIDDLE, DOUBLE, BORDER_LEFT, BORDER_RIGHT
    }

    public enum TransferAction {
        SHIFT_LEFT, SHIFT_RIGHT, NUMBER_KEY
    }

    public enum DropAction {
        DROP, DROP_STACK
    }


}
