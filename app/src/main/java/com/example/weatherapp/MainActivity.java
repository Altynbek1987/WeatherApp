package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView vector_graphic,vector_sunny, vector_humidity,vector_pressure,vector_wind,
            vector_sunset,vector_sunrise,vector_clock, vector_sun,vector_cloudy,vector_hazy;
    private Button btn_search;
    private TextView date,text_sunny,graduss,celci,temp_up, temp_down,number_humidity,text_humidity,number_pressure,text_pressure,
            number_wind,text_wind,number_sunset,text_sunset,number_sunrise,text_sunrise, number_clock,text_clock,number_sun,temp_up_sun,
            temp_down_sun,number_cloudy,temp_up_cloudy, temp_down_cloudy,number_hazy,temp_up_hazy,temp_down_hazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vector_graphic = findViewById(R.id.vector_graphic);vector_sunny = findViewById(R.id.vector_sunny);vector_humidity = findViewById(R.id.vector_humidity);
        vector_pressure = findViewById(R.id.vector_pressure);vector_wind = findViewById(R.id.vector_wind);vector_sunset = findViewById(R.id.vector_sunset);
        vector_sunrise = findViewById(R.id.vector_sunrise);vector_clock = findViewById(R.id.vector_clock);vector_sun = findViewById(R.id.vector_sun);
        vector_cloudy = findViewById(R.id.vector_cloudy);vector_hazy = findViewById(R.id.vector_hazy);
        btn_search = findViewById(R.id.btn_search);
        date = findViewById(R.id.date);text_sunny = findViewById(R.id.text_sunny);graduss = findViewById(R.id.graduss);
        celci = findViewById(R.id.celci);temp_up = findViewById(R.id.temp_up);temp_down = findViewById(R.id.temp_down);
        number_humidity = findViewById(R.id.number_humidity);text_humidity = findViewById(R.id.text_humidity);number_pressure = findViewById(R.id.number_pressure);
        text_pressure = findViewById(R.id.text_pressure);number_wind = findViewById(R.id.number_wind);text_wind = findViewById(R.id.text_wind);
        number_sunset = findViewById(R.id.number_sunset);text_sunset = findViewById(R.id.text_sunset);number_sunrise = findViewById(R.id.number_sunrise);
        text_sunrise = findViewById(R.id.text_sunrise);number_clock = findViewById(R.id.number_clock);text_clock = findViewById(R.id.text_clock);
        number_sun = findViewById(R.id.number_sun);temp_up_sun = findViewById(R.id.temp_up_sun);temp_down_sun = findViewById(R.id.temp_down_sun);
        number_cloudy = findViewById(R.id.number_cloudy);temp_up_cloudy = findViewById(R.id.temp_up_cloudy);temp_down_cloudy = findViewById(R.id.temp_down_cloudy);
        number_hazy = findViewById(R.id.number_hazy);temp_up_hazy = findViewById(R.id.temp_up_hazy);temp_down_hazy = findViewById(R.id.temp_down_hazy);

    }
}
