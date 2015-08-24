package com.dummyc0m.amethystcore.permission;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * com.dummyc0m.amethystcore.permission
 * Created by Dummyc0m on 4/4/15.
 */
public class PermissionListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.isAsynchronous()) {
            if (e.getPlayer().hasPermission(Permission.CHAT)) {
                e.setCancelled(true);
            }
        }
    }
}
