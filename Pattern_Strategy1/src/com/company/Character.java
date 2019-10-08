package com.company;

public abstract class Character {
    WeaponBehaviour weaponBehaviour;

    public Character(){
    }

    public abstract void fight();

    public void setWeapon(WeaponBehaviour w){
        weaponBehaviour = w;
    }

    public void performAttack(){
        weaponBehaviour.useWeapon();
    }
}
