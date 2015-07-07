package com.dummyc0m.amethystcore.framework.region;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 4/9/15.
 */
public class RegionListener implements Listener {
    private final ACRegionManager manager = ACRegionManager.getInstance();

    private final Map<UUID, Long> lastProcessed = new HashMap<>();
    private final Map<UUID, ACRegion> lastIn = new HashMap<>();

    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        long lastProcessTime = lastProcessed.get(player.getUniqueId());
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastProcessTime < 500) {
            return;
        }
        lastProcessed.put(player.getUniqueId(), currentTime);
        if (event.getFrom().getWorld() == event.getTo().getWorld()) {
            if (event.getFrom().distance(event.getTo()) == 0) {
                return;
            }
        }
        calculateMove(player, event.getTo());
    }

    private void calculateMove(Player player, Location location) {
        ACRegion region = manager.getRegion(location);
        if (region == null) {
            if (lastIn.containsKey(player.getUniqueId())) {
                lastIn.get(player.getUniqueId()).onDeparture(player);
                lastIn.remove(player.getUniqueId());
            }
            return;
        }
        if (lastIn.get(player.getUniqueId()) == region) {
            return;
        }
        lastIn.put(player.getUniqueId(), region);
        region.onEnter(player);
    }
}
