package com.company.Classes;
//Класс для декораторов. Должен быть взпимнозаменяемым с Beverage.
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
