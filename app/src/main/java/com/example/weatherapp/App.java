package com.example.weatherapp;

import android.app.Application;

import com.example.weatherapp.data.OpenWeatherMap;

public class App extends Application {
    public static OpenWeatherMap openWeatherMap;

    @Override
    public void onCreate() {
        super.onCreate();
        openWeatherMap = new OpenWeatherMap();
    }
}
