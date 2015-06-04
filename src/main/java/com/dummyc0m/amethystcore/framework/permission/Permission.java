package com.dummyc0m.amethystcore.framework.permission;

/**
 * com.dummyc0m.amethystcore.framework.permission
 * Created by Dummyc0m on 4/6/15.
 */
public enum Permission {
    MOVE("amethystcore.move"),
    PLACE_PREFIX("amethystcore.place."),
    BREAK_PREFIX("amethystcore.break."),
    INTERACT_PREFIX("amethystcore.interact."),
    DAMAGE_PREFIX("amethystcore.damage."),
    RECEIVE_PREFIX("amethystcore.receive."),
    TARGET_PREFIX("amethystcore.target."),
    PLACE_ALL("amethystcore.place.*"),
    BREAK_ALL("amethystcore.break.*"),
    INTERACT_ALL("amethystcore.interact.*"),
    DAMAGE_ALL("amethystcore.damage.*"),
    RECEIVE_ALL("amethystcore.receive.*"),
    TARGET_ALL("amethystcore.target.*"),
    CHAT("amethystcore.chat");


    private String permission;

    Permission(final String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return this.permission;
    }
}
