package com.company.Classes;
//Класс для напитка еспрессо, расширяет класс Beverage.
public class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}
