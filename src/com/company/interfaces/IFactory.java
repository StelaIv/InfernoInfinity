package com.company.interfaces;

import com.company.models.Weapon;
import com.company.enums.GemType;
import com.company.enums.WeaponType;

public interface IFactory {
    Weapon createWeapon(WeaponType weaponType, String weaponName);

    void addGemsToWeapon(Weapon weapon, int socketIndex, GemType gemType);

    void removeGemFromAWeapon(Weapon weapon, int socketIndex);

    String printWeapon(Weapon weapon);
}
