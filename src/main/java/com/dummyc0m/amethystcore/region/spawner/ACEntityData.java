package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.item.ACAbstractItem;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

/**
 * Created by Dummyc0m on 8/14/15.
 * First Version
 */
public class ACEntityData {
    private final EntityType entityType;
    private final String customName;
    private final Collection<PotionEffect> potionEffects;
    private final double maxHealth;
    private final double health;


    private final ItemStack itemInHand;
    private final ItemStack[] armorContent;
    private final float[] dropChances;

    /**
     * @param entityType    NotNull
     * @param maxHealth     NotNull
     * @param health        NotNull
     * @param customName
     * @param potionEffects
     * @param itemInHand
     * @param armorContent  format:[helmet, chestplate, leggings, boots]
     * @param dropChances   format:[heldItem, helmet, chestplate, leggings, boots]
     */
    public ACEntityData(EntityType entityType, double maxHealth, double health, String customName, Collection<PotionEffect> potionEffects, ItemStack itemInHand, ItemStack[] armorContent, float[] dropChances) {
        this.maxHealth = maxHealth;
        this.health = health;
        this.entityType = entityType;
        this.customName = customName;
        this.potionEffects = potionEffects;
        this.itemInHand = itemInHand;
        if (armorContent == null) {
            this.armorContent = new ItemStack[]{null, null, null, null};
        } else {
            this.armorContent = armorContent;
        }
        if (dropChances == null) {
            this.dropChances = new float[]{0F, 0F, 0F, 0F, 0F};
        } else {
            this.dropChances = dropChances;
        }
    }

    /**
     * @param entityType    NotNull
     * @param maxHealth     NotNull
     * @param health        NotNull
     * @param customName
     * @param potionEffects
     * @param itemInHand
     * @param helmet
     * @param chestplate
     * @param leggings
     * @param boots
     * @param dropChances   format:[heldItem, helmet, chestplate, leggings, boots]
     */
    public ACEntityData(EntityType entityType, double maxHealth, double health, String customName, Collection<PotionEffect> potionEffects, ACAbstractItem itemInHand, ACAbstractItem helmet, ACAbstractItem chestplate, ACAbstractItem leggings, ACAbstractItem boots, float[] dropChances) {
        this(entityType, maxHealth, health, customName, potionEffects, itemInHand.getItemStack(), new ItemStack[]{helmet == null ? null : helmet.getItemStack(), chestplate == null ? null : chestplate.getItemStack(), leggings == null ? null : leggings.getItemStack(), boots == null ? null : boots.getItemStack()}, dropChances);
    }

    public void spawnEntity(Location location) {
        Entity entity = location.getWorld().spawnEntity(location, entityType);
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.setMaxHealth(maxHealth);
            livingEntity.setHealth(health);
            if (potionEffects != null && !potionEffects.isEmpty()) {
                livingEntity.addPotionEffects(potionEffects);
            }
            if (customName != null && !customName.equalsIgnoreCase("")) {
                livingEntity.setCustomNameVisible(true);
                livingEntity.setCustomName(customName);
            }
            EntityEquipment equipment = livingEntity.getEquipment();
            if (itemInHand != null) {
                equipment.setItemInHand(itemInHand);
            }
            equipment.setArmorContents(armorContent);
            equipment.setItemInHandDropChance(dropChances[0]);
            equipment.setHelmetDropChance(dropChances[1]);
            equipment.setChestplateDropChance(dropChances[2]);
            equipment.setLeggingsDropChance(dropChances[3]);
            equipment.setBootsDropChance(dropChances[4]);
        }
    }
}
