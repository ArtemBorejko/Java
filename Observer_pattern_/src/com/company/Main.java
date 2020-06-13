package com.company;

import com.company.Classes.CurrentConditionsDisplay;
import com.company.Classes.WeatherData;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(25, 65, 25.3f);
        weatherData.notifyObservers();
        weatherData.setMeasurements(27, 80, 26.4f);
        weatherData.notifyObservers();
        weatherData.setMeasurements(23, 95, 22.1f);
        weatherData.notifyObservers();
    }
}
