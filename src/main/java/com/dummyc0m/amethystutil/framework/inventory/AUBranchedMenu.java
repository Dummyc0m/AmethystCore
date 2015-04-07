package com.dummyc0m.amethystutil.framework.inventory;

import org.bukkit.inventory.ItemStack;

/**
 * com.dummyc0m.amethystutil.framework.inventory
 * Created by Dummyc0m on 3/19/15.
 */
public class AUBranchedMenu extends AUMenu {
    private AUMenu prev;

    public AUBranchedMenu(int size, String title, AUButton[] contents, AUMenu prev) {
        super(size, title, contents);
        this.prev = prev;
    }

    public AUBranchedMenu(int size, String title, AUMenu prev) {
        super(size, title);
        this.prev = prev;
    }

    public AUMenu getPrev() {
        return prev;
    }

    public void setPrev(AUMenu prev) {
        this.prev = prev;
    }
}
