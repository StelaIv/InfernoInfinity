package com.company.interfaces;

import com.company.enums.WeaponType;
import com.company.enums.GemType;

public interface IWeapon {
    String getName();

    WeaponType getWeaponType();

    GemType[] getSockets();

    int getVitality();

    int getAgility();

    int getStrength();

    int getMinDamage();

    int getMaxDamage();

    void addBonus(GemType gemType, int socketIndex);

    void removeBonus(GemType gemType);

}
