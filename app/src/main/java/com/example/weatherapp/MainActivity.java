package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.OpenWeatherMap;
import com.example.weatherapp.models.WeatherModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OpenWeatherMap.WeatherCallback {
    List<WeatherModel> list;
    private ImageView vector_graphic, vector_sunny,
             vector_clock, vector_sun, vector_cloudy, vector_hazy;
    private Button btn_search;
    private TextView date, text_sunny, graduss, temp_up, temp_down, number_humidity, number_pressure,
            number_wind, number_sunset, number_sunrise, number_clock, number_sun, temp_up_sun,
            temp_down_sun, number_cloudy, temp_up_cloudy, temp_down_cloudy, number_hazy, temp_up_hazy, temp_down_hazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.openWeatherMap.getWeatherData(this);
        vector_graphic = findViewById(R.id.vector_graphic);vector_sunny = findViewById(R.id.vector_sunny);
        vector_clock = findViewById(R.id.vector_clock);
        vector_sun = findViewById(R.id.vector_sun);vector_cloudy = findViewById(R.id.vector_cloudy);
        vector_hazy = findViewById(R.id.vector_hazy);btn_search = findViewById(R.id.btn_search);
        date = findViewById(R.id.date);

        text_sunny = findViewById(R.id.text_sunny);graduss = findViewById(R.id.graduss);temp_up = findViewById(R.id.temp_up);
        temp_down = findViewById(R.id.temp_down);number_humidity = findViewById(R.id.number_humidity);number_pressure = findViewById(R.id.number_pressure);
        number_wind = findViewById(R.id.number_wind);number_sunset = findViewById(R.id.number_sunset);number_sunrise = findViewById(R.id.number_sunrise);
        number_clock = findViewById(R.id.number_clock);number_sun = findViewById(R.id.number_sun);temp_up_sun = findViewById(R.id.temp_up_sun);
        temp_down_sun = findViewById(R.id.temp_down_sun);number_cloudy = findViewById(R.id.number_cloudy);temp_up_cloudy = findViewById(R.id.temp_up_cloudy);
        temp_down_cloudy = findViewById(R.id.temp_down_cloudy);number_hazy = findViewById(R.id.number_hazy);temp_up_hazy = findViewById(R.id.temp_up_hazy);
        temp_down_hazy = findViewById(R.id.temp_down_hazy);

    }

    @Override
    public void onSuccess(WeatherModel body) {
        Log.e("tag", "MainActivity onSuccess");
        text_sunny.setText(body.getWeather().get(0).getMain());
        Glide.with((this)).load("http://openweathermap.org/img/wn/" + body.
                getWeather().get(0).getIcon() + "@2x.png").centerCrop().into(vector_sunny);

        graduss.setText(body.getMain().getTemp().intValue() + "\u2103");
        temp_up.setText(body.getMain().getTempMax().intValue() + "\u2103" + "↑");
        temp_down.setText(body.getMain().getTempMin().intValue() + "\u2103" + "↓");
        number_humidity.setText(body.getMain().getHumidity().intValue() + "%");
        number_pressure.setText(body.getMain().getPressure() + "mBar");
        number_wind.setText(body.getWind().getSpeed() + "km/h");
        long am = Long.valueOf(body.getSys().getSunrise()) * 1000;// это должно быть в миллисекундах
        Date sunrise = new java.util.Date(am);
        String sunr = new SimpleDateFormat(" hh:mma").format(sunrise);
        number_sunrise.setText(sunr);

        long pm = Long.valueOf(body.getSys().getSunset()) * 1000;
        Date sunset = new java.util.Date(pm);
        String suns = new SimpleDateFormat(" hh:mma").format(sunset);
        number_sunset.setText(suns);

        String currentDate = new SimpleDateFormat("EEEE-dd-MM-yyyy-HH:mm", Locale.getDefault()).format(new Date());
        date.setText(currentDate);

        btn_search.setText(body.getName());


//String vv = new SimpleDateFormat("MM dd, yyyy hh:mma").format(df);
    }

    @Override
    public void onFailure(Exception e) {

    }
}
