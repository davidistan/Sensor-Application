package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.assignment2.R;

public class Activity2 extends AppCompatActivity implements SensorEventListener {
    float total = 0;
    float total_times = 0;
    float total_dev = 0;
    float avg = 0;
    SensorManager sm;
    Sensor light_sensor;
    protected void onCreate(Bundle savedInstanceState) {
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        light_sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        float range = light_sensor.getMaximumRange();
        float res = light_sensor.getResolution();
        int delay = light_sensor.getMaxDelay();
        Log.v("Light_Range", "" + light_sensor.getMaximumRange());
        Log.v("Light_Resolution", "" + light_sensor.getResolution());
        Log.v("Light_Delay", "" + delay);
        sm.registerListener(this, light_sensor, 1000000);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float light = event.values[0];
            if (light < 80) {
                Light_Animation light_anim = findViewById(R.id.light_view);
                light_anim.setBackgroundResource(R.drawable.l1_anim);
                ((AnimationDrawable) light_anim.getBackground()).start();

            } else if (light >= 80 && light < 200) {
                Light_Animation light_anim = findViewById(R.id.light_view);
                light_anim.setBackgroundResource(R.drawable.l2_anim);
                ((AnimationDrawable) light_anim.getBackground()).start();

            } else if (light >= 200) {
                Light_Animation light_anim = findViewById(R.id.light_view);
                light_anim.setBackgroundResource(R.drawable.l3_anim);
                ((AnimationDrawable) light_anim.getBackground()).start();

            }
            total = total + light;
            total_times = total_times + 1;
            avg = total/total_times;
            total_dev = total_dev + (float) Math.pow((light - avg), 2);
            float sec = System.currentTimeMillis();
            float time = (System.currentTimeMillis()%1313);
//            Log.v("LIGHT", "" + light);
            Light_View l_view = findViewById(R.id.l_view);
            l_view.seconds(sec);
            l_view.average(total, total_times);
            l_view.addPoint(light);
            l_view.addTime(time);
            l_view.st_dev(total_dev, total_times);
            l_view.invalidate();



        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
