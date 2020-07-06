package com.company;

import com.company.Classes.NYPizzaStore;
import com.company.Classes.Pizza;
import com.company.Classes.PizzaStore;

public class Main {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("You are ordered a " + pizza.getName());
    }
}
