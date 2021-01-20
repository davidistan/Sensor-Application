package com.example.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Accelo_View extends View {
    ArrayList<Float> secondz = new ArrayList<>(10);
    ArrayList<Float> points = new ArrayList<>(10);
    ArrayList<Float> times = new ArrayList<>(10);
    float avg = 0;
    float stan_dev = 0;
    public Accelo_View(Context context) {
        super(context);
    }

    public Accelo_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Accelo_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onDraw(Canvas canvas) {
        Paint milli = new Paint();
        milli.setColor(Color.WHITE);
        milli.setTextSize(35);
        Paint x = new Paint();
        x.setColor(Color.WHITE);
        x.setTextSize(15);
        Paint b = new Paint();
        b.setColor(Color.BLUE);
        b.setTextSize(35);
        Paint r = new Paint();
        r.setColor(Color.RED);
        r.setTextSize(40);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(35);
        Paint black = new Paint();
        black.setColor(Color.WHITE);
        black.setTextSize(60);
        canvas.drawText("Accelerometer Plot", canvas.getWidth()/5, 120, black);
        canvas.drawRect(canvas.getWidth() * (float) 0.1, 20, canvas.getWidth() * (float) 0.15, 60, r);
        canvas.drawText("Average", canvas.getWidth() * (float) 0.175, 55, r);
        canvas.drawText("milliseconds", (int) (canvas.getWidth()/3), canvas.getHeight() - 50, milli);
        canvas.drawRect(canvas.getWidth() * (float) 0.3, 20, canvas.getWidth() * (float) 0.35, 60, p);
        canvas.drawText("Data", canvas.getWidth() * (float) 0.375, 55, p);
        canvas.drawRect(canvas.getWidth() * (float) 0.44643, 20, canvas.getWidth() * (float) 0.49643, 60, b);
        canvas.drawText("Standard Deviation", canvas.getWidth() * (float) 0.52143, 55, b);
        float eighth = canvas.getWidth()/8;
        float modified_canvas = canvas.getHeight() - 100;
        float five_offset = (float) (canvas.getHeight() * 0.1);
        canvas.drawText("" + 0, 25, ((canvas.getHeight() - 100)), p);
        canvas.drawLine(50, modified_canvas - 20, canvas.getWidth(), modified_canvas - 20, p);
        canvas.drawText("" + 10, 25, ((canvas.getHeight() - 100) - five_offset), p);
        canvas.drawLine(50, (modified_canvas - five_offset) - 20, canvas.getWidth(), (modified_canvas - five_offset) - 20, p);
        float ten_offset = (float) (canvas.getHeight() * 0.2);
        canvas.drawText("" + 20, 0, (canvas.getHeight() - 100) - ten_offset, p);
        canvas.drawLine(50, (modified_canvas - ten_offset) - 20, canvas.getWidth(), (modified_canvas - ten_offset) - 20, p);
        float fifteen_offset = (float) (canvas.getHeight() * 0.3);
        canvas.drawLine(50, (modified_canvas - fifteen_offset) - 20, canvas.getWidth(), (modified_canvas - fifteen_offset) - 20, p);
        canvas.drawText("" + 30, 0, (canvas.getHeight() - 100) - fifteen_offset, p);
        float twenty_offset = (float) (canvas.getHeight() * 0.4);
        canvas.drawLine(50, (modified_canvas - twenty_offset) - 20, canvas.getWidth(), (modified_canvas - twenty_offset) - 20, p);
        canvas.drawText("" + 40, 0, (canvas.getHeight() - 100) - twenty_offset, p);
        float two_five_offset = (float) (canvas.getHeight() * 0.5);
        canvas.drawLine(50, (modified_canvas - two_five_offset) - 20, canvas.getWidth(), (modified_canvas - two_five_offset) - 20, p);
        canvas.drawText("" + 50, 0, (canvas.getHeight() - 100) - two_five_offset, p);
        float thirty_offset = (float) (canvas.getHeight() * 0.6);
        canvas.drawLine(50, (modified_canvas - thirty_offset) - 20, canvas.getWidth(), (modified_canvas - thirty_offset) - 20, p);
        canvas.drawText("" + 60, 0, (canvas.getHeight() - 100) - thirty_offset, p);
        float three_five_offset = (float) (canvas.getHeight() * 0.7);
        canvas.drawLine(50, (modified_canvas - three_five_offset) - 20, canvas.getWidth(), (modified_canvas - three_five_offset) - 20, p);
        canvas.drawText("" + 70, 0, (canvas.getHeight() - 100) - three_five_offset, p);
        float forty_offset = (float) (canvas.getHeight() * 0.8);
        canvas.drawLine(50, (modified_canvas - forty_offset) - 20, canvas.getWidth(), (modified_canvas - forty_offset) - 20, p);
        canvas.drawText("" + 80, 0, (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 1), modified_canvas, (eighth * 1), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 2), modified_canvas, (eighth * 2), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 3), modified_canvas, (eighth * 3), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 4), modified_canvas, (eighth * 4), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 5), modified_canvas, (eighth * 5), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 6), modified_canvas, (eighth * 6), (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawLine((eighth * 7), modified_canvas, (eighth * 7), (canvas.getHeight() - 100) - forty_offset, p);
        for (int i = 0; i < points.size(); i++) {
            canvas.drawText("" + secondz.get(i), times.get(i), canvas.getHeight() - 75, x);
            
            if (i < points.size() - 1) {
                canvas.drawCircle(times.get(i), ((modified_canvas - (modified_canvas * (avg / 90))) - 25), 25, r);
                canvas.drawLine(times.get(i), ((modified_canvas - (modified_canvas * (avg / 90))) - 25), times.get(i + 1),
                        ((modified_canvas - (modified_canvas * (avg / 90))) - 25), r);
                canvas.drawCircle(times.get(i), ((modified_canvas - (modified_canvas * (points.get(i) / 90))) - 25), 25, p);
                canvas.drawLine(times.get(i), ((modified_canvas - (modified_canvas * (points.get(i) / 90))) - 25), times.get(i + 1),
                        ((modified_canvas - (modified_canvas * (points.get(i + 1) / 90))) - 25), p);
                if (stan_dev < 1) {
                    canvas.drawCircle(times.get(i), modified_canvas - 25, 25, b);
                    canvas.drawLine(times.get(i), modified_canvas - 25, times.get(i + 1),
                            modified_canvas - 20, b);
                } else if (stan_dev != 0) {
                    canvas.drawCircle(times.get(i), ((modified_canvas - (modified_canvas * (stan_dev / 90))) - 25), 25, b);
                    canvas.drawLine(times.get(i), ((modified_canvas - (modified_canvas * (stan_dev / 90))) - 25), times.get(i + 1),
                            ((modified_canvas - (modified_canvas * (stan_dev / 90))) - 25), b);
                }
                
            } else {
                canvas.drawCircle(times.get(i), modified_canvas - (((modified_canvas * (points.get(i) / 90))) - 25), 25, p);
                canvas.drawCircle(times.get(i), modified_canvas - (((modified_canvas * (avg / 90))) - 25), 25, r);
                if (stan_dev < 1) {
                    canvas.drawCircle(times.get(i), modified_canvas - 25, 25, b);
                } else if (stan_dev != 0) {
                    canvas.drawCircle(times.get(i), ((modified_canvas - (modified_canvas * (stan_dev / 90))) - 25), 25, b);
                }
            }
        }
    }

    public void average(float total, float times) {
        avg = total/times;
    }

    public void addPoint(float f) {
        if (points.size() == 10) {
            points.remove(0);
            points.add(f);
        } else {
            points.add(f);
        }
    }

    public void addTime(float f) {
        if (times.size() == 10) {
            times.remove(0);
            times.add(f);
        } else {
            times.add(f);
        }
    }

    public void st_dev(float f, float g) {
        float variance = f/(g - 1);
        stan_dev = (float) Math.sqrt(variance);
    }

    public void seconds(float f) {
        if (secondz.size() == 10) {
            secondz.remove(0);
            secondz.add(f);
        } else {
            secondz.add(f);
        }
    }
}
