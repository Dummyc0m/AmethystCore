package com.dummyc0m.amethystcore.framework.module;

import org.bukkit.entity.Player;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 4/18/15.
 */
public class ACModuleManager {
    private static ACModuleManager instance = new ACModuleManager();
    private Map<UUID, WeakReference<ACModule>> playerMap = new HashMap<>();

    public static ACModuleManager getInstance() {
        return instance;
    }

    public void registerPlayer(Player player, ACModule acModule) {
        this.playerMap.put(player.getUniqueId(), new WeakReference<ACModule>(acModule));
    }

    public void deregisterPlayer(Player player) {
        this.playerMap.remove(player.getUniqueId());
    }

    public ACModule getModule(Player player) {
        return this.playerMap.get(player.getUniqueId()).get();
    }

}
