package com.company;

public class Troll extends Character {
    public Troll(){
        weaponBehaviour = new KnifeBehaviour();
    }

    public void fight() {
        System.out.println("I'm a troll!");
    }
}
