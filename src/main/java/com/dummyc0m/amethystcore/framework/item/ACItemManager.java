package com.dummyc0m.amethystcore.framework.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.dummyc0m.amethystcore.framework.item
 * Created by Dummyc0m on 4/2/15.
 */
public class ACItemManager {
    private final Map<String, ACItem> identifierMap;
    private final String hideFlag;

    public ACItemManager() {
        identifierMap = new HashMap<>();
        hideFlag = "Hide:";
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
        if (identifier.startsWith(hideFlag)) {
            return this.identifierMap.get(identifier.replaceFirst(hideFlag, ""));
        }
        return this.identifierMap.get(identifier);
    }
}
