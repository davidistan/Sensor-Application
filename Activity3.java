package com.example.assignment2;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.assignment2.R;

public class Activity3 extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor proximity_sensor;

    protected void onCreate(Bundle savedInstanceState) {
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity_sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, proximity_sensor, 500000);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void back(View view) {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float distance = event.values[0];
            TextView text = (findViewById(R.id.p_sensor));
            text.setText("" + distance + "");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
