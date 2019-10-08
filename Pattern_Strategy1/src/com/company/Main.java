package com.company;

public class Main {

    public static void main(String[] args) {
	Main main = new Main();
	main.troll();
    }

    public void troll(){
        Character troll = new Troll();
        troll.performAttack();
        troll.setWeapon(new AxeBehaviour());
        troll.performAttack();
    }
}
