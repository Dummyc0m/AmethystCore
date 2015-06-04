package com.dummyc0m.amethystcore.framework.module;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 4/18/15.
 */
public class ACModuleHandler {
    private static ACModuleHandler instance = new ACModuleHandler();
    private Map<String, ACModule> identifierMap = new HashMap<>();
    private Map<UUID, ACModule> playerMap = new HashMap<>();

    public static ACModuleHandler getInstance() {
        return instance;
    }

    public void registerModules(List<ACModule> acModules) {
        acModules.forEach(this::registerModule);
    }

    public void registerModule(ACModule acModule) {
        this.identifierMap.put(acModule.getIdentifier(), acModule);
    }

    public void deregisterModule(String identifier) {
        this.identifierMap.remove(identifier);
    }

    public void registerPlayer(Player player, ACModule acModule) {
        this.playerMap.put(player.getUniqueId(), acModule);
    }

    public void deregisterPlayer(Player player) {
        this.playerMap.remove(player.getUniqueId());
    }

    public ACModule getModule(Player player) {
        return this.playerMap.get(player.getUniqueId());
    }

    public ACModule getModule(String identifier) {
        return this.identifierMap.get(identifier);
    }

}
