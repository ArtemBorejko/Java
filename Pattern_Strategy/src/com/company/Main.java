package com.company;

import com.company.Classes.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.mallard();
        main.decoy();
    }

    public void mallard(){
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    public void decoy(){
        Duck decoy = new DecoyDuck();
        decoy.performQuack();
        decoy.setQuackBehaviour(new Squeak());
        decoy.performQuack();
        decoy.performFly();
        decoy.setFlyBehaviour(new FlyRocketPowered());
        decoy.performFly();
    }
}
