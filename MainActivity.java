package com.example.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void light_foo(View view) {
        Intent a_2 = new Intent(this, Activity2.class);
        startActivity(a_2);
    }

    public void proximity_foo(View view) {
        Intent a_3 = new Intent(this, Activity3.class);
        startActivity(a_3);
    }

    public void accelo_foo(View view) {
        Intent a_4 = new Intent(this, Activity4.class);
        startActivity(a_4);
    }
}
