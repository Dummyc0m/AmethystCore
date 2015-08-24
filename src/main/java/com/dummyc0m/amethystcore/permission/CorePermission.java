package com.dummyc0m.amethystcore.permission;

import com.dummyc0m.amethystcore.AmethystCore;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dummyc0m on 5/20/15.
 */
public class CorePermission {
    private final Map<UUID, PermissionAttachment> attachmentMap;
    private Field pField;

    public CorePermission() {
        this.attachmentMap = new HashMap<>();
    }

    public void initPerms(Player player) {
        PermissionAttachment attachment = player.addAttachment(AmethystCore.getInstance());
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
