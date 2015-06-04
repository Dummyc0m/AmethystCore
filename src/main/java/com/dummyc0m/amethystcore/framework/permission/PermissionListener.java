package com.dummyc0m.amethystcore.framework.permission;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * com.dummyc0m.amethystcore.framework.permission
 * Created by Dummyc0m on 4/4/15.
 */
public class PermissionListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onMove(PlayerMoveEvent e) {
        if (!e.getPlayer().hasPermission(Permission.MOVE.toString())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlaceBlock(BlockPlaceEvent e) {
        if (e.getPlayer().hasPermission(Permission.PLACE_ALL.toString())) {
            return;
        }
        if (!e.getPlayer().hasPermission(Permission.PLACE_PREFIX + e.getBlockPlaced().getType().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getPlayer().hasPermission(Permission.BREAK_ALL.toString())) {
            return;
        }
        if (!e.getPlayer().hasPermission(Permission.BREAK_PREFIX + e.getBlock().getType().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteract(PlayerInteractEvent e) {
        if (e.getPlayer().hasPermission(Permission.INTERACT_ALL.toString())) {
            return;
        }
        if (!e.getPlayer().hasPermission(Permission.INTERACT_PREFIX + e.getClickedBlock().getType().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getDamager();
        if (player.hasPermission(Permission.DAMAGE_ALL.toString())) {
            return;
        }
        if (!player.hasPermission(Permission.DAMAGE_PREFIX + e.getEntity().getType().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onReceive(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getEntity();
        if (player.hasPermission(Permission.RECEIVE_ALL.toString())) {
            return;
        }
        if (!player.hasPermission(Permission.RECEIVE_PREFIX + e.getCause().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onTarget(EntityTargetLivingEntityEvent e) {
        if (!(e.getTarget() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getTarget();
        if (player.hasPermission(Permission.TARGET_ALL.toString())) {
            return;
        }
        if (!player.hasPermission(Permission.TARGET_PREFIX + e.getEntityType().name())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.isAsynchronous()) {
            if (e.getPlayer().hasPermission(Permission.CHAT.toString())) {
                e.setCancelled(true);
            }
        }
    }
}
