package com.company.Classes;

import com.company.Interfaces.DisplayElement;
import com.company.Interfaces.Observer;
import com.company.Interfaces.Subject;

// Класс реализует интерфейсы Observer, DisplayElement
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temp;
    private float hum;
    private float pressure;
    private Subject weatherData;
// Конструктор класса, здесь конструктору передается объект WeatherData.
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
// Реализация метода update, где мы сохраняем значение а дальше вызываем метод display().
    public void update(float temp, float hum, float pressure){
        this.temp = temp;
        this.hum = hum;
        this.pressure = pressure;
        display();
    }
//  Метод выводит значения температуры, влажности и давления.
    public void display(){
        System.out.println("Current conditions: " + temp + " C degrees and " + hum + " % humidity and " + pressure + " pascals");
    }
}
