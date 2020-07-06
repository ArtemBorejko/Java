package com.company.Interfaces;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggeies();
    Pepperoni createPepperoni();
    Clam createClam();
}
