
package com.example.assignment2;

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
import android.widget.ImageView;

import com.example.assignment2.R;

public class Activity4 extends AppCompatActivity implements SensorEventListener {
    float total_acceleration = 0;
    float total_times = 0;
    float avg = 0;
    float total_dev = 0;
    SensorManager sm;
    Sensor accelo_sensor;
    
    protected void onCreate(Bundle savedInstanceState) {
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelo_sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        float range = accelo_sensor.getMaximumRange();
        float res = accelo_sensor.getResolution();
        int delay = accelo_sensor.getMaxDelay();
        Log.v("Acceleration_Range", "" + accelo_sensor.getMaximumRange());
        Log.v("Acceleration_Resolution", "" + accelo_sensor.getResolution());
        Log.v("Acceleration_Delay", "" + delay);
        sm.registerListener(this, accelo_sensor, 1000000);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float sec = System.currentTimeMillis();
            float acceleration = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
            if (acceleration < 15) {
                Acceleration_Animation anim = (findViewById(R.id.anim));
                anim.setBackgroundResource(R.drawable.accelo_anim);
                ((AnimationDrawable) anim.getBackground()).start();
            } else if (acceleration >= 15 && acceleration < 25) {
                Acceleration_Animation anim = (findViewById(R.id.anim));
                anim.setBackgroundResource(R.drawable.accelerom);
                ((AnimationDrawable) anim.getBackground()).start();
            } else if (acceleration >= 25 && acceleration < 35) {
                Acceleration_Animation anim = (findViewById(R.id.anim));
                anim.setBackgroundResource(R.drawable.accelerome);
                ((AnimationDrawable) anim.getBackground()).start();
            } else if (acceleration > 35) {
                Acceleration_Animation anim = (findViewById(R.id.anim));
                anim.setBackgroundResource(R.drawable.accelerometer_anim);
                ((AnimationDrawable) anim.getBackground()).start();
            }
            
            float time = System.currentTimeMillis()%1313;
            total_acceleration = total_acceleration + acceleration;
            total_times = total_times + 1;
            avg = total_acceleration/total_times;
            total_dev = total_dev + (float) Math.pow((acceleration - avg), 2);
            
            Accelo_View a = (findViewById(R.id.a_view));
            a.seconds(sec);
            a.addPoint(acceleration);
            a.addTime(time);
            a.average(total_acceleration, total_times);
            a.st_dev(total_dev, total_times);
            a.invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
