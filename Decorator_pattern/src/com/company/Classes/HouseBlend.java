package com.company.Classes;
//Класс для напитка домашнего кофе, расширяет класс Beverage.
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House blend";
    }

    public double cost(){
        return .99;
    }
}
