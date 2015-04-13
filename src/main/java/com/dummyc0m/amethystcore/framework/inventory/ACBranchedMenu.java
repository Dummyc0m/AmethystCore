package com.dummyc0m.amethystcore.framework.inventory;

/**
 * com.dummyc0m.amethystcore.framework.inventory
 * Created by Dummyc0m on 3/19/15.
 */
public class ACBranchedMenu extends ACMenu {
    private ACMenu prev;

    public ACBranchedMenu(int size, String title, ACButton[] contents, ACMenu prev) {
        super(size, title, contents);
        this.prev = prev;
    }

    public ACBranchedMenu(int size, String title, ACMenu prev) {
        super(size, title);
        this.prev = prev;
    }

    public ACMenu getPrev() {
        return prev;
    }

    public void setPrev(ACMenu prev) {
        this.prev = prev;
    }
}
