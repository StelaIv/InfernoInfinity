package com.company.factory;

import com.company.enums.GemType;
import com.company.enums.WeaponType;
import com.company.interfaces.IFactory;
import com.company.interfaces.IWeapon;
import com.company.models.Weapon;

public class WeaponFactory implements IFactory {

    public WeaponFactory() {
    }

    @Override
    public Weapon createWeapon(WeaponType weaponType, String weaponName) {
        Weapon weapon = new Weapon(weaponType, weaponName);
        return weapon;
    }

    @Override
    public void addGemsToWeapon(IWeapon weapon, int socketIndex, GemType gemType) {
        if (weapon.isValidIndex(socketIndex)) {
            if (weapon.getSockets()[socketIndex]!=null){
                this.removeGemFromAWeapon(weapon,socketIndex);
            }
            weapon.addBonus(gemType, socketIndex);
        }
    }

    @Override
    public void removeGemFromAWeapon(IWeapon weapon, int socketIndex) {
        if (weapon.isValidIndex(socketIndex)) {
            GemType gemType = weapon.getSockets()[socketIndex];
            if (gemType != null) {
                weapon.removeBonus(gemType);
            }
            weapon.getSockets()[socketIndex]=null;
        }
    }

    @Override
    public String printWeapon(IWeapon weapon) {
        return weapon.toString();
    }
}
