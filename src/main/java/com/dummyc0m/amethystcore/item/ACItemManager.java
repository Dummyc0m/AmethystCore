package com.dummyc0m.amethystcore.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.dummyc0m.amethystcore.item
 * Created by Dummyc0m on 4/2/15.
 */
public class ACItemManager {
    private final Map<String, ACAbstractItem> identifierMap;
    private final String hideFlag;

    public ACItemManager() {
        identifierMap = new HashMap<>();
        hideFlag = "Hide:";
    }

    public void registerItems(List<ACAbstractItem> acAbstractItems) {
        acAbstractItems.forEach(this::registerItem);
    }

    public void registerItem(ACAbstractItem acAbstractItem) {
        this.identifierMap.put(acAbstractItem.getIdentifier(), acAbstractItem);
    }

    public void deregisterItem(String identifier) {
        this.identifierMap.remove(identifier);
    }

    public ACAbstractItem getItem(String identifier) {
        if (identifier.startsWith(hideFlag)) {
            return this.identifierMap.get(identifier.replaceFirst(hideFlag, ""));
        }
        return this.identifierMap.get(identifier);
    }
}
