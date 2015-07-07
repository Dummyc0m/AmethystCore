package com.dummyc0m.amethystcore.framework.permission;

import com.dummyc0m.amethystcore.AmethystCore;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 5/20/15.
 */
public class ACPerms {
    private static final ACPerms INSTANCE = new ACPerms(AmethystCore.getInstance());
    private final Map<UUID, PermissionAttachment> attachmentMap;
    private final JavaPlugin plugin;
    private Field pField;

    public ACPerms(JavaPlugin plugin) {
        this.plugin = plugin;
        this.attachmentMap = new HashMap<>();
    }

    public static ACPerms getInstance() {
        return INSTANCE;
    }

    public void initPerms(Player player) {
        PermissionAttachment attachment = player.addAttachment(this.plugin);
        this.attachmentMap.put(player.getUniqueId(), attachment);
        Map<String, Boolean> directMap = this.reflectMap(attachment);
        directMap.clear();
    }

    protected void calculatePerms(Player player, Map<String, Boolean> permissions) {
        Map<String, Boolean> directMap = this.reflectMap(this.attachmentMap.get(player.getUniqueId()));
        directMap.putAll(permissions);
        player.recalculatePermissions();
    }

    public void grantPerm(Player player, String permission) {
        this.attachmentMap.get(player.getUniqueId()).setPermission(permission, true);
    }

    public void grantPerms(Player player, List<String> permissions) {
        permissions.forEach((permission) -> grantPerm(player, permission));
    }

    @SuppressWarnings("unchecked")
    private Map<String, Boolean> reflectMap(PermissionAttachment attachment) {
        try {
            if (pField == null) {
                pField = PermissionAttachment.class.getDeclaredField("permissions");
                pField.setAccessible(true);
            }
            return (Map<String, Boolean>) pField.get(attachment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
