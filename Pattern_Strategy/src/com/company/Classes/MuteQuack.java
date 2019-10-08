package com.company.Classes;

import com.company.Interfaces.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
