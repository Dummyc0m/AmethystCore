package com.dummyc0m.amethystutil.framework.item;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * com.dummyc0m.amethystutil.framework.inventory
 * Created by Dummyc0m on 3/15/15.
 */
public class ItemListener implements Listener {

    private AUItemHandler handler = AUItemHandler.getInstance();
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event){
        ItemStack itemStack = event.getItem();
        if(itemStack == null || !itemStack.hasItemMeta()){
            return;
        }
        List<String> lore = itemStack.getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onInteract(event.getPlayer(), event.getAction(), event.getClickedBlock(), event.getBlockFace()));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event){
        ItemStack itemStack = event.getPlayer().getItemInHand();
        if(itemStack == null || !itemStack.hasItemMeta()){
            return;
        }
        List<String> lore = itemStack.getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onEntityInteract(event.getPlayer(), event.getRightClicked(), event.getClickedPosition()));
        }
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
        List<String> lore = event.getItem().getItemStack().getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onPickUp(event.getPlayer(), event.getRemaining()));
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        List<String> lore = event.getItemDrop().getItemStack().getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onDrop(event.getPlayer()));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerSelectItem(PlayerItemHeldEvent event){
        ItemStack itemStack = event.getPlayer().getItemInHand();
        if(itemStack == null || !itemStack.hasItemMeta()){
            return;
        }
        List<String> lore = itemStack.getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if (item != null) {
            event.setCancelled(item.onSelected(event.getPlayer(), event.getPreviousSlot(), event.getNewSlot()));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerConsume(PlayerItemConsumeEvent event){
        List<String> lore = event.getItem().getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onConsume(event.getPlayer()));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerBreakItem(PlayerItemBreakEvent event){
        List<String> lore = event.getBrokenItem().getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            item.onBreak(event.getPlayer());
        }
    }



    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event){
        ItemStack itemStack = event.getCurrentItem();
        if(itemStack == null) return;
        List<String> lore = itemStack.getItemMeta().getLore();
        if(lore == null) return;
        AUItem item = handler.getItem(lore.get(lore.size() - 1));
        if(item != null){
            event.setCancelled(item.onInventoryInteract(event.getWhoClicked(), event.getSlotType(), event.getSlot(), event.getClick(), itemStack));
        }
    }
}
