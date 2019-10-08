package com.company.Classes;

public class DecoyDuck extends Duck {
    public DecoyDuck(){
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }

    public void display() {
        System.out.println("I'm a Decoy duck");
    }
}
