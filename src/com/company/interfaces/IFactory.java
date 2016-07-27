package com.company.interfaces;

import com.company.enums.GemType;
import com.company.enums.WeaponType;

public interface IFactory {
    IWeapon createWeapon(WeaponType weaponType, String weaponName);

    void addGemsToWeapon(IWeapon weapon, int socketIndex, GemType gemType);

    void removeGemFromAWeapon(IWeapon weapon, int socketIndex);

    String printWeapon(IWeapon weapon);
}
