package com.company.models;

import com.company.interfaces.IWeapon;
import com.company.enums.GemType;
import com.company.enums.WeaponType;

public class Weapon implements IWeapon {

    private static final int STRENGTH_BONUS_TO_MIN_DAMAGE = 2;
    private static final int STRENGTH_BONUS_TO_MAX_DAMAGE = 3;
    private static final int AGILITY_BONUS_TO_MAX_DAMAGE = 4;

    private WeaponType weaponType;
    private String name;
    private int strength;
    private int agility;
    private int vitality;
    private GemType[] sockets;
    private int minDamage;
    private int maxDamage;

    public Weapon(WeaponType weaponType, String name) {
        this.setWeaponType(weaponType);
        this.setName(name);
        this.strength = 0;
        this.agility = 0;
        this.vitality =0;
        this.setSockets();
        this.minDamage = weaponType.getMinDamage();
        this.maxDamage = weaponType.getMaxDamage();
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSockets() {
        this.sockets = new GemType[weaponType.getNumberOfSockets()];
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setVitality(int vitality) {
        this.vitality = vitality;
    }

    protected void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    protected void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public boolean isValidIndex(int socketIndex) {
        return socketIndex >= 0 && socketIndex < this.getSockets().length;
    }

    @Override
    public void removeBonus(GemType gemType) {
        this.setAgility(this.getAgility() - gemType.getAgility());
        this.setStrength(this.getStrength() - gemType.getStrength());
        this.setVitality(this.getVitality() - gemType.getVitality());
        this.setMinDamage(this.getMinDamage()
                - (gemType.getStrength() * STRENGTH_BONUS_TO_MIN_DAMAGE)
                - gemType.getAgility());
        this.setMaxDamage(this.getMaxDamage()
                - (gemType.getStrength() * STRENGTH_BONUS_TO_MAX_DAMAGE)
                - (gemType.getAgility() * AGILITY_BONUS_TO_MAX_DAMAGE));
    }

    @Override
    public void addBonus(GemType gemType, int socketIndex) {
        this.getSockets()[socketIndex] = gemType;
        this.setAgility(this.getAgility() + gemType.getAgility());
        this.setStrength(this.getStrength() + gemType.getStrength());
        this.setVitality(this.getVitality() + gemType.getVitality());
        this.setMinDamage(this.getMinDamage()
                +(gemType.getStrength() * STRENGTH_BONUS_TO_MIN_DAMAGE)
                + gemType.getAgility());
        this.setMaxDamage(this.getMaxDamage()
                +(gemType.getStrength() * STRENGTH_BONUS_TO_MAX_DAMAGE)
                + (gemType.getAgility() * AGILITY_BONUS_TO_MAX_DAMAGE));
    }

    @Override
    public GemType[] getSockets() {
        return this.sockets;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    @Override
    public int getAgility() {
        return this.agility;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getMinDamage() {
        return this.minDamage;
    }

    @Override
    public int getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }
}
