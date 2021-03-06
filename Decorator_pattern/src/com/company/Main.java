package com.company;

import com.company.Classes.*;

public class Main {

    public static void main(String[] args) {
        //Сдесь мы видим явную связь между объектами, от такого следует отказатся.
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " " + beverage.cost() + "$");
        //Сдесь тоже.
        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println(beverage1.getDescription() + " " + beverage1.cost() + "$");
    }
}
