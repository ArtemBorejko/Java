package com.company.Classes;
//Класс для декоратора шоколад, расширяет класс CondimentDecorator, который в свою очередь, расширяет класс Beverage.
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}
