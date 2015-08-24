package com.dummyc0m.amethystcore.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dummyc0m on 8/24/15.
 */
public class PermissionGroups {
    private final Map<String, Map<String, Boolean>> permissionGroupMap;

    public PermissionGroups() {
        permissionGroupMap = new HashMap<>();
    }

    public void addPermissionGroup(String id, List<String> permissions) {
        Map<String, Boolean> permissionMap = new HashMap<>();
        permissions.forEach(permission -> permissionMap.put(permission, true));
        this.permissionGroupMap.put(id, permissionMap);
    }

    public void removePermissionGroup(String id) {
        permissionGroupMap.remove(id);
    }

    public Map<String, Boolean> getGroupPermission(String id) {
        return permissionGroupMap.get(id);
    }
}
