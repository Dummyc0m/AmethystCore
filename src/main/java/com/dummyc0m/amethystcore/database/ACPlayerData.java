package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.framework.module.ACModule;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.UUID;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACPlayerData {
    private String playerName;
    private UUID playerUUID;

    private ACModule module;
    private int experience;
    private int expLvl;

    private int amethyst;
    private int fluorite;

    private int resonance;
    private int frost;
    private int flare;
    private int gemRain;

    private boolean longBow;
    private boolean speedEffect;
    private boolean speedEffectEnabled;
    private boolean jumpEffect;
    private boolean jumpEffectEnabled;
    private boolean privateMsg;
    private boolean flight;
    private boolean jetPack;

    public ACPlayerData(String playerName, UUID playerUUID, ACModule module, int experience, int expLvl, int amethyst, int fluorite, int resonance, int frost, int flare, int gemRain, boolean longBow, boolean speedEffect, boolean speedEffectEnabled, boolean jumpEffect, boolean jumpEffectEnabled, boolean privateMsg, boolean flight, boolean jetPack) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.module = module;
        this.experience = experience;
        this.expLvl = expLvl;
        this.amethyst = amethyst;
        this.fluorite = fluorite;
        this.resonance = resonance;
        this.frost = frost;
        this.flare = flare;
        this.gemRain = gemRain;
        this.longBow = longBow;
        this.speedEffect = speedEffect;
        this.speedEffectEnabled = speedEffectEnabled;
        this.jumpEffect = jumpEffect;
        this.jumpEffectEnabled = jumpEffectEnabled;
        this.privateMsg = privateMsg;
        this.flight = flight;
        this.jetPack = jetPack;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public ACModule getModule() {
        return module;
    }

    public void setModule(ACModule module) {
        this.module = module;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExpLvl() {
        return expLvl;
    }

    public void setExpLvl(int expLvl) {
        this.expLvl = expLvl;
    }

    public int getAmethyst() {
        return amethyst;
    }

    public void setAmethyst(int amethyst) {
        this.amethyst = amethyst;
    }

    public int getFluorite() {
        return fluorite;
    }

    public void setFluorite(int fluorite) {
        this.fluorite = fluorite;
    }

    public int getResonance() {
        return resonance;
    }

    public void setResonance(int resonance) {
        this.resonance = resonance;
    }

    public int getFrost() {
        return frost;
    }

    public void setFrost(int frost) {
        this.frost = frost;
    }

    public int getFlare() {
        return flare;
    }

    public void setFlare(int flare) {
        this.flare = flare;
    }

    public int getGemRain() {
        return gemRain;
    }

    public void setGemRain(int gemRain) {
        this.gemRain = gemRain;
    }

    public boolean isLongBow() {
        return longBow;
    }

    public void setLongBow(boolean longBow) {
        this.longBow = longBow;
    }

    public boolean isSpeedEffect() {
        return speedEffect;
    }

    public void setSpeedEffect(boolean speedEffect) {
        this.speedEffect = speedEffect;
    }

    public boolean isSpeedEffectEnabled() {
        return speedEffectEnabled;
    }

    public void setSpeedEffectEnabled(boolean speedEffectEnabled) {
        this.speedEffectEnabled = speedEffectEnabled;
    }

    public boolean isJumpEffect() {
        return jumpEffect;
    }

    public void setJumpEffect(boolean jumpEffect) {
        this.jumpEffect = jumpEffect;
    }

    public boolean isJumpEffectEnabled() {
        return jumpEffectEnabled;
    }

    public void setJumpEffectEnabled(boolean jumpEffectEnabled) {
        this.jumpEffectEnabled = jumpEffectEnabled;
    }

    public boolean isPrivateMsg() {
        return privateMsg;
    }

    public void setPrivateMsg(boolean privateMsg) {
        this.privateMsg = privateMsg;
    }

    public boolean isFlight() {
        return flight;
    }

    public void setFlight(boolean flight) {
        this.flight = flight;
    }

    public boolean isJetPack() {
        return jetPack;
    }

    public void setJetPack(boolean jetPack) {
        this.jetPack = jetPack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACPlayerData that = (ACPlayerData) o;

        return new EqualsBuilder()
                .append(experience, that.experience)
                .append(expLvl, that.expLvl)
                .append(amethyst, that.amethyst)
                .append(fluorite, that.fluorite)
                .append(resonance, that.resonance)
                .append(frost, that.frost)
                .append(flare, that.flare)
                .append(gemRain, that.gemRain)
                .append(longBow, that.longBow)
                .append(speedEffect, that.speedEffect)
                .append(speedEffectEnabled, that.speedEffectEnabled)
                .append(jumpEffect, that.jumpEffect)
                .append(jumpEffectEnabled, that.jumpEffectEnabled)
                .append(privateMsg, that.privateMsg)
                .append(flight, that.flight)
                .append(jetPack, that.jetPack)
                .append(playerName, that.playerName)
                .append(playerUUID, that.playerUUID)
                .append(module, that.module)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(playerName)
                .append(playerUUID)
                .append(module)
                .append(experience)
                .append(expLvl)
                .append(amethyst)
                .append(fluorite)
                .append(resonance)
                .append(frost)
                .append(flare)
                .append(gemRain)
                .append(longBow)
                .append(speedEffect)
                .append(speedEffectEnabled)
                .append(jumpEffect)
                .append(jumpEffectEnabled)
                .append(privateMsg)
                .append(flight)
                .append(jetPack)
                .toHashCode();
    }
}
