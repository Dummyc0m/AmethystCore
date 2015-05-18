package com.dummyc0m.amethystcore.test;

import com.dummyc0m.amethystcore.framework.inventory.ACButton;
import com.dummyc0m.amethystcore.framework.inventory.ACButtonData;
import com.dummyc0m.amethystcore.framework.inventory.ACMenu;
import com.dummyc0m.amethystcore.framework.item.ACItem;
import com.dummyc0m.amethystcore.framework.item.ACItemData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystcore.test
 * Created by Dummyc0m on 4/3/15.
 */
public class ItemCore extends ACItem {
    private ACMenu compassMenu;

    public ItemCore() {
    }

    public ItemCore(ACItemData data, String module, String identifier) {
        super(data, module, identifier);
        this.compassMenu = new ACMenu(27, "AmethystCore");
        ACButton[] buttons = new ACButton[27];
        ACButtonData buttonData = new ACButtonData(Material.EMERALD);
        buttons[13] = new ACButton(buttonData) {
            @Override
            public ItemStack onClick(ACMenu menu, HumanEntity humanEntity, ACMenu.ClickAction clickAction, ItemStack item) {
                humanEntity.sendMessage("hahahahaha");
                return super.onClick(menu, humanEntity, clickAction, item);
            }
        };
        this.compassMenu.setContents(buttons);
    }

    @Override
    public boolean onDrop(Player who) {
        who.sendMessage(super.onDrop(who) ? "true" : "false");
        return super.onDrop(who);
    }

    @Override
    public boolean onInteract(Player who, Action action, Block clickedBlock, BlockFace clickedFace) {
        this.compassMenu.display(who);
        return super.onInteract(who, action, clickedBlock, clickedFace);
    }
}
