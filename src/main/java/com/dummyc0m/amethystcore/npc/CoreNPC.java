package com.dummyc0m.amethystcore.npc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 8/24/15.
 */
public class CoreNPC {
    private final Map<UUID, INPCAction> npcActionMap;

    public CoreNPC() {
        npcActionMap = new HashMap<>();
    }

    public void addAction(UUID uuid, INPCAction action) {
        npcActionMap.put(uuid, action);
    }

    public INPCAction getAction(UUID uuid) {
        return npcActionMap.get(uuid);
    }

    public void removeAction(UUID uuid) {
        npcActionMap.remove(uuid);
    }
}
