package com.company.Classes;

import com.company.Interfaces.Observer;
import com.company.Interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

// Реализация класса WeatherData
public class WeatherData implements Subject {
    private float temp;
    private float hum;
    private float pressure;
    private List observers;

    // Конструктор
    public WeatherData(){
        observers = new ArrayList();
    }
    // Реализация метода registerObserver из интерфейса Subject
    public void registerObserver(Observer o){
        observers.add(o);
    }
    // Реализация метода removeObserver из интерфейса Subject
    public void removeObserver(Observer o){
        int index = observers.indexOf(o);
        if(index >= 0)
        observers.remove(index);
    }
    // Реализация метода notifyObservers из интерфейса Subject
    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temp, hum, pressure);
        }
    }
    // Оповещение наблюдателей
    public void measurumentsChanged(){
        notifyObservers();
    }
    // Метод для переопределения значений
    public void setMeasurements(float temp, float hum, float pressure){
        this.temp = temp;
        this.hum = hum;
        this.pressure = pressure;
    }
}
