package com.dummyc0m.amethystutil.test;

import com.dummyc0m.amethystutil.AmethystUtil;
import com.dummyc0m.amethystutil.framework.inventory.AUButton;
import com.dummyc0m.amethystutil.framework.inventory.AUButtonData;
import com.dummyc0m.amethystutil.framework.inventory.AUMenu;
import com.dummyc0m.amethystutil.framework.item.AUItem;
import com.dummyc0m.amethystutil.framework.item.AUItemData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystutil.test
 * Created by Dummyc0m on 4/3/15.
 */
public class Compass extends AUItem {
    private AUMenu compassMenu;

    public Compass() {
    }

    public Compass(AUItemData data, String module, String identifier) {
        super(data, module, identifier);
        this.compassMenu = new AUMenu(27, "Compass");
        AUButton[] buttons = new AUButton[27];
        AUButtonData buttonData = new AUButtonData(Material.COMPASS);
        buttons[0] = new AUButton(buttonData) {
            @Override
            public ItemStack onClick(AUMenu menu, HumanEntity humanEntity, AUMenu.ClickAction clickAction, ItemStack item) {
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
