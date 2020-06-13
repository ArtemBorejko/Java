package com.company;

import com.company.Classes.CurrentConditionsDisplay;
import com.company.Classes.WeatherData;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        currentConditionsDisplay.update(26, 45, 25.8f);
        currentConditionsDisplay.update(27, 68, 23.3f);
        currentConditionsDisplay.update(29, 78, 22.1f);
    }
}
