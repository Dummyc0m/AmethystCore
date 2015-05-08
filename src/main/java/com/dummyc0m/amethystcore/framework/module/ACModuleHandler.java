package com.dummyc0m.amethystcore.framework.module;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dummyc0m on 4/18/15.
 */
public class ACModuleHandler {
    private static ACModuleHandler instance = new ACModuleHandler();
    private HashMap<String, ACModule> identifierMap = new HashMap<>();

    public static ACModuleHandler getInstance() {
        return instance;
    }

    public void registerModules(List<ACModule> acModules) {
        acModules.forEach(this::registerModule);
    }

    public void registerModule(ACModule acModule) {
        this.identifierMap.put(acModule.getIdentifier(), acModule);
    }

    public ACModule unregisterModule(String identifier) {
        return this.identifierMap.remove(identifier);
    }

    public ACModule getModule(String identifier) {
        return this.identifierMap.get(identifier);
    }

}
