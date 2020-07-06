package com.company.Classes;

import com.company.Interfaces.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
        PizzaIngredientFactory ingredientFactory;

        public ClamPizza(PizzaIngredientFactory ingredientFactory) {
            this.ingredientFactory = ingredientFactory;
        }

    @Override
    void prepare() {

    }
}
