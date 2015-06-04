package com.dummyc0m.amethystcore.framework.module;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * com.dummyc0m.amethystcore.framework.module
 * Created by Dummyc0m on 4/4/15.
 */
public class ModuleListener implements Listener {

    private ACModuleHandler handler = ACModuleHandler.getInstance();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setFormat(handler.getModule(e.getPlayer()).getChatFormat());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(handler.getModule(e.getPlayer()).onLogoff(e.getPlayer(), e.getQuitMessage()));
    }
}
