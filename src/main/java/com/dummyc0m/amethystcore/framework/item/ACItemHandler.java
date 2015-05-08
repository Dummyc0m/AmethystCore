package com.dummyc0m.amethystcore.framework.item;

import com.dummyc0m.amethystcore.util.ACFormat;

import java.util.HashMap;
import java.util.List;

/**
 * com.dummyc0m.amethystcore.framework.item
 * Created by Dummyc0m on 4/2/15.
 */
public class ACItemHandler {
    private static ACItemHandler instance = new ACItemHandler();
    private HashMap<String, ACItem> identifierMap = new HashMap<>();

    public static ACItemHandler getInstance() {
        return instance;
    }

    public void registerItems(List<ACItem> acItems) {
        acItems.forEach(this::registerItem);
    }

    public void registerItem(ACItem acItem) {
        this.identifierMap.put(acItem.getIdentifier(), acItem);
    }

    public ACItem unregisterItem(String identifier) {
        return this.identifierMap.remove(identifier);
    }

    public ACItem getItem(String identifier) {
        if (identifier.startsWith(ACFormat.RESET + ACFormat.DARK_GRAY)) {
            return this.identifierMap.get(identifier.replaceFirst(ACFormat.RESET + ACFormat.DARK_GRAY, ""));
        }
        return null;
    }
}
