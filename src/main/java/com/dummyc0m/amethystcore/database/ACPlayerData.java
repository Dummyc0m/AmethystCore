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

    private int gunLevel;

    private int ammo;
    private int flame;
    private int firework;
    private int gemBullet;
    private int enderPearl;
    private int railgun;
    private int explosive;
    private int textFlare;

    private String flareContent;

    private int jetpackLevel;
    private int validUntil;
    private boolean autoReload;

    public ACPlayerData(String playerName, UUID playerUUID, ACModule module, int experience, int expLvl, int amethyst, int fluorite, int gunLevel, int ammo, int flame, int firework, int gemBullet, int enderPearl, int railgun, int explosive, int textFlare, String flareContent, int jetpackLevel, int validUntil, boolean autoReload) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.module = module;
        this.experience = experience;
        this.expLvl = expLvl;
        this.amethyst = amethyst;
        this.fluorite = fluorite;
        this.gunLevel = gunLevel;
        this.ammo = ammo;
        this.flame = flame;
        this.firework = firework;
        this.gemBullet = gemBullet;
        this.enderPearl = enderPearl;
        this.railgun = railgun;
        this.explosive = explosive;
        this.textFlare = textFlare;
        this.flareContent = flareContent;
        this.jetpackLevel = jetpackLevel;
        this.validUntil = validUntil;
        this.autoReload = autoReload;
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

    public int getGunLevel() {
        return gunLevel;
    }

    public void setGunLevel(int gunLevel) {
        this.gunLevel = gunLevel;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getFlame() {
        return flame;
    }

    public void setFlame(int flame) {
        this.flame = flame;
    }

    public int getFirework() {
        return firework;
    }

    public void setFirework(int firework) {
        this.firework = firework;
    }

    public int getGemBullet() {
        return gemBullet;
    }

    public void setGemBullet(int gemBullet) {
        this.gemBullet = gemBullet;
    }

    public int getEnderPearl() {
        return enderPearl;
    }

    public void setEnderPearl(int enderPearl) {
        this.enderPearl = enderPearl;
    }

    public int getRailgun() {
        return railgun;
    }

    public void setRailgun(int railgun) {
        this.railgun = railgun;
    }

    public int getExplosive() {
        return explosive;
    }

    public void setExplosive(int explosive) {
        this.explosive = explosive;
    }

    public int getTextFlare() {
        return textFlare;
    }

    public void setTextFlare(int textFlare) {
        this.textFlare = textFlare;
    }

    public String getFlareContent() {
        return flareContent;
    }

    public void setFlareContent(String flareContent) {
        this.flareContent = flareContent;
    }

    public int getJetpackLevel() {
        return jetpackLevel;
    }

    public void setJetpackLevel(int jetpackLevel) {
        this.jetpackLevel = jetpackLevel;
    }

    public int getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(int validUntil) {
        this.validUntil = validUntil;
    }

    public boolean isAutoReload() {
        return autoReload;
    }

    public void setAutoReload(boolean autoReload) {
        this.autoReload = autoReload;
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
                .append(gunLevel, that.gunLevel)
                .append(ammo, that.ammo)
                .append(flame, that.flame)
                .append(firework, that.firework)
                .append(gemBullet, that.gemBullet)
                .append(enderPearl, that.enderPearl)
                .append(railgun, that.railgun)
                .append(explosive, that.explosive)
                .append(textFlare, that.textFlare)
                .append(jetpackLevel, that.jetpackLevel)
                .append(validUntil, that.validUntil)
                .append(autoReload, that.autoReload)
                .append(playerName, that.playerName)
                .append(playerUUID, that.playerUUID)
                .append(module, that.module)
                .append(flareContent, that.flareContent)
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
                .append(gunLevel)
                .append(ammo)
                .append(flame)
                .append(firework)
                .append(gemBullet)
                .append(enderPearl)
                .append(railgun)
                .append(explosive)
                .append(textFlare)
                .append(flareContent)
                .append(jetpackLevel)
                .append(validUntil)
                .append(autoReload)
                .toHashCode();
    }
}
