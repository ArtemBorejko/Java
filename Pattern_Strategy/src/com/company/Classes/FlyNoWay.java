package com.company.Classes;

import com.company.Interfaces.FlyBehaviour;

public class FlyNoWay implements FlyBehaviour {
    public void fly() {
        System.out.println("I can't fly!");
    }
}
