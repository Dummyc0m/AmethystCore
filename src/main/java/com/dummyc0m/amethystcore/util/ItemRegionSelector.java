package com.dummyc0m.amethystcore.util;

import com.dummyc0m.amethystcore.AmethystCore;
import com.dummyc0m.amethystcore.framework.item.ACItem;
import com.dummyc0m.amethystcore.framework.item.ACItemData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Created by Dummyc0m on 7/14/15.
 */
public class ItemRegionSelector extends ACItem {
    public ItemRegionSelector() {
        super(new ACItemData(Material.BLAZE_ROD, (short) 0, 1, true, false, true, true, false, true), "AmethystCore", "amethystcore:regionselector");
    }

    @Override
    public boolean onInteract(Player who, Action action, Block clickedBlock, BlockFace clickedFace) {
        if (!clickedBlock.isEmpty()) {
            if (action == Action.LEFT_CLICK_BLOCK) {
                who.setMetadata("leftClicked", new FixedMetadataValue(AmethystCore.getInstance(), clickedBlock.getLocation()));
            } else if (action == Action.RIGHT_CLICK_BLOCK) {
                who.setMetadata("rightClicked", new FixedMetadataValue(AmethystCore.getInstance(), clickedBlock.getLocation()));
            }

        }
        return super.onInteract(who, action, clickedBlock, clickedFace);
    }
//
//    public void setMetadata(Metadatable object, String key, Object value, Plugin plugin) {
//        object.setMetadata(key, new FixedMetadataValue(plugin,value));
//    }
//
//    public Object getMetadata(Metadatable object, String key, Plugin plugin) {
//        List<MetadataValue> values = object.getMetadata(key);
//        for (MetadataValue value : values) {
//            // Plugins are singleton objects, so using == is safe here
//            if (value.getOwningPlugin() == plugin) {
//                return value.value();
//            }
//        }
//        return null;
//    }

}
