package com.dummyc0m.amethystcore.region;

import com.dummyc0m.amethystcore.util.FormatUtil;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.entity.Player;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public abstract class ACAbstractRegion implements IACRegion {
    private final String name;
    private final String displayName;
    private final String greeting;
    private final String farewell;

    public ACAbstractRegion(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
        this.greeting = FormatUtil.GRAY + "[已进入" + displayName + "]";
        this.farewell = FormatUtil.GRAY + "[已离开" + displayName + "]";
    }

    @Override
    public boolean onEnter(Player player) {
        player.sendMessage(greeting);
        return false;
    }

    @Override
    public boolean onDeparture(Player player) {
        player.sendMessage(farewell);
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACAbstractRegion that = (ACAbstractRegion) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(displayName, that.displayName)
                .append(greeting, that.greeting)
                .append(farewell, that.farewell)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(displayName)
                .append(greeting)
                .append(farewell)
                .toHashCode();
    }
}
