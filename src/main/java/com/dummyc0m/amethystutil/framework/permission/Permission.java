package com.dummyc0m.amethystutil.framework.permission;

import java.util.regex.Pattern;

/**
 * com.dummyc0m.amethystutil.framework.permission
 * Created by Dummyc0m on 4/6/15.
 */
public enum Permission {
    COMMAND_TELEPORT("amethystutil.command.teleport"),
    COMMAND_GAMEMODE("amethystutil.command.gamemode"),
    COMMAND_BAN("amethystutil.command.ban"),

    COMMAND_CONFIG_RELOAD("amethystutil.command.config.reload")

    ;
    private Pattern pattern;

    private Permission(String regex){
        this.pattern = Pattern.compile(regex);
    }

    public boolean matches(String string){
        return this.pattern.matcher(string).matches();
    }
}
