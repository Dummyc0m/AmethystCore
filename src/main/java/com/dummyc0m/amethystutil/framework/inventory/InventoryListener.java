package com.dummyc0m.amethystutil.framework.inventory;

import com.dummyc0m.amethystutil.framework.item.AUItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystutil.framework.item
 * Created by Dummyc0m on 3/15/15.
 */
public class InventoryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryOpen(InventoryOpenEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if(holder != null && holder instanceof AUMenuHolder){
            ((AUMenuHolder) holder).getMenu().onOpen(event.getInventory(), event.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClose(InventoryCloseEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if(holder != null && holder instanceof AUMenuHolder){
            ((AUMenuHolder) holder).getMenu().onClose(event.getInventory(), event.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if(holder != null && holder instanceof AUMenuHolder){
            event.setCurrentItem(((AUMenuHolder) holder).getMenu().onClick(event.getInventory(), event.getSlotType(), event.getSlot(), event.getClick(), event.getCurrentItem(), event.getWhoClicked()));
            event.setCancelled(true);
        }
    }


}
