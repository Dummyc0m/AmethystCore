package com.dummyc0m.amethystcore.framework.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.dummyc0m.amethystcore.framework.item
 * Created by Dummyc0m on 4/2/15.
 */
public class ACItemManager {
    private static final ACItemManager instance = new ACItemManager();
    private final Map<String, ACItem> identifierMap = new HashMap<>();

    public static ACItemManager getInstance() {
        return instance;
    }

    public void registerItems(List<ACItem> acItems) {
        acItems.forEach(this::registerItem);
    }

    public void registerItem(ACItem acItem) {
        this.identifierMap.put(acItem.getIdentifier(), acItem);
    }

    public void deregisterItem(String identifier) {
        this.identifierMap.remove(identifier);
    }

    public ACItem getItem(String identifier) {
        if (identifier.startsWith("Hide:")) {
            return this.identifierMap.get(identifier.replaceFirst("Hide:", ""));
        }
        return this.identifierMap.get(identifier);
    }
}
