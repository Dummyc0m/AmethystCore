package com.dummyc0m.amethystcore.npc;

import com.dummyc0m.amethystcore.AmethystCore;
import com.dummyc0m.amethystcore.util.MetaDataUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.world.ChunkLoadEvent;

/**
 * Created by Dummyc0m on 8/24/15.
 */
public class NPCListener implements Listener {
    private final AmethystCore plugin;
    private final CoreNPC coreNPC;

    public NPCListener(AmethystCore plugin, CoreNPC coreNPC) {
        this.plugin = plugin;
        this.coreNPC = coreNPC;
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        Entity[] entities = event.getChunk().getEntities();
        for (Entity entity : entities) {
            if (entity instanceof Villager && MetaDataUtil.getMetadata(entity, "NPCAction", plugin) == null) {
                INPCAction action = coreNPC.getAction(entity.getUniqueId());
                if (action != null) {
                    MetaDataUtil.setMetadata(entity, "NPCAction", action, plugin);
                }
            }
        }
    }

    public void onEntityInteract(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Villager) {
            INPCAction action = (INPCAction) MetaDataUtil.getMetadata(event.getRightClicked(), "NPCAction", plugin);
            if (action != null) {
                event.setCancelled(true);
                action.onClick(event.getPlayer(), event.getRightClicked(), event.getClickedPosition());
            }
        }
    }
}
