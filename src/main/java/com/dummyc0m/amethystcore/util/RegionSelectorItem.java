package com.dummyc0m.amethystcore.util;

import com.dummyc0m.amethystcore.AmethystCore;
import com.dummyc0m.amethystcore.item.ACAbstractItem;
import com.dummyc0m.amethystcore.item.ACItemData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Created by Dummyc0m on 7/14/15.
 */
public class RegionSelectorItem extends ACAbstractItem {
    public RegionSelectorItem() {
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

}
