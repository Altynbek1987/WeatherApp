package com.example.weatherapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.weatherapp.data.OpenWeatherMap;
import com.example.weatherapp.models.WeatherModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OpenWeatherMap.WeatherCallback {
    List<WeatherModel> list;
    private ImageView vector_image, vector_sunny;
    private Button btn_search;
    private TextView date, text_sunny, graduss, text_lot, text_lat, number_humidity, number_pressure,
            number_wind, number_sunset, number_sunrise, number_cloud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.openWeatherMap.getWeatherData(this);
        vector_image = findViewById(R.id.vector_image);
        vector_sunny = findViewById(R.id.vector_sunny);
        btn_search = findViewById(R.id.btn_search);
        date = findViewById(R.id.date);
        text_sunny = findViewById(R.id.text_sunny);
        graduss = findViewById(R.id.graduss);
        text_lot = findViewById(R.id.text_lot);
        text_lat = findViewById(R.id.text_lat);
        number_humidity = findViewById(R.id.number_humidity);
        number_pressure = findViewById(R.id.number_pressure);
        number_wind = findViewById(R.id.number_wind);
        number_sunset = findViewById(R.id.number_sunset);
        number_sunrise = findViewById(R.id.number_sunrise);
        number_cloud = findViewById(R.id.number_cloud);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onSuccess(WeatherModel body) {
        Log.e("tag", "MainActivity onSuccess");
        btn_search.setText(body.getName());
        text_sunny.setText(body.getWeather().get(0).getDescription());
        Glide.with((this)).load("http://openweathermap.org/img/wn/" + body.
                getWeather().get(0).getIcon() + "@2x.png").centerCrop().into(vector_sunny);
        graduss.setText(body.getMain().getTemp().intValue() + "\u2103");
        text_lot.setText(body.getCoord().getLon() + " долгота");
        text_lat.setText(body.getCoord().getLat() + " широта");
        number_humidity.setText(body.getMain().getHumidity().intValue() + "%");
        number_pressure.setText(body.getMain().getPressure() + "mBar");
        number_wind.setText(body.getWind().getSpeed() + "km/h");
        number_cloud.setText(body.getClouds().getAll() + "%");

        long am = Long.valueOf(body.getSys().getSunrise()) * 1000;// это должно быть в миллисекундах
        Date sunrise = new java.util.Date(am);
        String sunr = new SimpleDateFormat(" HH:mma").format(sunrise);
        number_sunrise.setText(sunr);

        long pm = Long.valueOf(body.getSys().getSunset()) * 1000;
        Date sunset = new java.util.Date(pm);
        String suns = new SimpleDateFormat(" HH:mma").format(sunset);
        number_sunset.setText(suns);

        String currentDate = new SimpleDateFormat("EEEE-dd-MM-yyyy-HH:mma", Locale.getDefault()).format(new Date());
        date.setText(currentDate);

        try {
            Date dDate = new SimpleDateFormat("EEEE-dd-MM-yyyy-HH:mma").parse(currentDate);
            if (dDate.after(sunrise)) {

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (sunr.equals(currentDate)){
            Glide.with((this)).load(getDrawable(R.drawable.day_image)).into(vector_image);
        }else {
            Glide.with((this)).load(getDrawable(R.drawable.night_image)).into(vector_image);
        }

        Toast.makeText(this,   "Добро пожаловать" , Toast.LENGTH_SHORT).show();


//String vv = new SimpleDateFormat("MM dd, yyyy hh:mma").format(df);
    }

    @Override
    public void onFailure(Exception e) {

    }
}
