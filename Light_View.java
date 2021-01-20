package com.example.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Light_View extends View {
    boolean full = false;
    float light_total = 0;
    float total_times = 0;
    float avg = 0;
    float stan_dev = 0;
    ArrayList<Float> secondz = new ArrayList<>(10);
    ArrayList<Float> points = new ArrayList<Float>(10);
    ArrayList<Float> time = new ArrayList<Float>(10);
    float point;
    public Light_View(Context context) {
        super(context);
    }

    public Light_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Light_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onDraw(Canvas canvas) {
        // Fix Canvas_Height - 20 for the rest of this method
        Paint b = new Paint();
        b.setColor(Color.BLUE);
        b.setTextSize(35);
        Paint r = new Paint();
        r.setColor(Color.RED);
        r.setTextSize(40);
        Paint milli = new Paint();
        milli.setColor(Color.WHITE);
        milli.setTextSize(35);
        Paint x = new Paint();
        x.setColor(Color.WHITE);
        x.setTextSize(15);
        float twenty = canvas.getWidth()/20;
        canvas.drawRect(canvas.getWidth() * (float) 0.1, 0, canvas.getWidth() * (float) 0.15, 40, r);
        canvas.drawText("Average", canvas.getWidth() * (float) 0.175, 35, r);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setTextSize(40);
        canvas.drawText("milliseconds", (int) (canvas.getWidth()/3.333), canvas.getHeight() - 50, milli);
        canvas.drawRect(canvas.getWidth() * (float) 0.3, 0, canvas.getWidth() * (float) 0.35, 40, p);
        canvas.drawText("Data", canvas.getWidth() * (float) 0.375, 35, p);
        canvas.drawRect(canvas.getWidth() * (float) 0.44643, 0, canvas.getWidth() * (float) 0.49643, 40, b);
        canvas.drawText("Standard Deviation", canvas.getWidth() * (float) 0.52143, 35, b);
        float offset = (float) 0.04762;
        canvas.drawLine(75, ((canvas.getHeight() - 100)) - 20, canvas.getWidth(), ((canvas.getHeight() - 100)) - 20, p);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (float) 0.04762)) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (float) 0.04762)) - 20, p);
        float twenty_offset = (canvas.getHeight() - 100) * (offset * 2);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - twenty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - twenty_offset) - 20, p);
        float thirty_offset = (canvas.getHeight() - 100) * (float) (offset * 3);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - thirty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - thirty_offset) - 20, p);
        float forty_offset = (canvas.getHeight() - 100) * (float) (offset * 4);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - forty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - forty_offset) - 20, p);
        float fifty_offset = (canvas.getHeight() - 100) * (float) (offset * 5);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - fifty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - fifty_offset) - 20, p);
        float sixty_offset = (canvas.getHeight() - 100) * (float) (offset * 6);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - sixty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - sixty_offset) - 20, p);
        float seventy_offset = (canvas.getHeight() - 100) * (float) (offset * 7);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - seventy_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - seventy_offset) - 20, p);
        float eighty_offset = (canvas.getHeight() - 100) * (float) (offset * 8);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - eighty_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - eighty_offset) - 20, p);
        float ninety_offset = (canvas.getHeight() - 100) * (float) (offset * 9);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - ninety_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - ninety_offset) - 20, p);
        float hundred_offset = (canvas.getHeight() - 100) * (float) (offset * 10);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - hundred_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - hundred_offset) - 20, p);
        float one_ten_offset = (canvas.getHeight() - 100) * (float) (offset * 11);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_ten_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_ten_offset) - 20, p);
        float one_two_offset = (canvas.getHeight() - 100) * (float) (offset * 12);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_two_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_two_offset) - 20, p);
        float one_three_offset = (canvas.getHeight() - 100) * (float) (offset * 13);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_three_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_three_offset) - 20, p);
        float one_four_offset = (canvas.getHeight() - 100) * (float) (offset * 14);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_four_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_four_offset) - 20, p);
        float one_five_offset = (canvas.getHeight() - 100) * (float) (offset * 15);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_five_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_five_offset) - 20, p);
        float one_six_offset = (canvas.getHeight() - 100) * (float) (offset * 16);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_six_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_six_offset) - 20, p);
        float one_seven_offset = (canvas.getHeight() - 100) * (float) (offset * 17);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_seven_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_seven_offset) - 20, p);
        float one_eight_offset = (canvas.getHeight() - 100) * (float) (offset * 18);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_eight_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_eight_offset) - 20, p);
        float one_nine_offset = (canvas.getHeight() - 100) * (float) (offset * 19);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - one_nine_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - one_nine_offset) - 20, p);
        float two_hun_offset = (canvas.getHeight() - 100) * (offset * 20);
        canvas.drawLine(75, ((canvas.getHeight() - 100) - two_hun_offset) - 20, canvas.getWidth(), ((canvas.getHeight() - 100) - two_hun_offset) - 20, p);
      //  canvas.drawLine(0, two_hun_offset, canvas.getWidth(), two_hun_offset, p);
        canvas.drawText("" + 0, 50, canvas.getHeight() - 100, p);
        canvas.drawText("" + 25, 25, (canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * offset), p);
        canvas.drawText("" + 50, 25, (canvas.getHeight() - 100) - twenty_offset, p);
        canvas.drawText("" + 75, 25, (canvas.getHeight() - 100) - thirty_offset, p);
        canvas.drawText("" + 100, 0, (canvas.getHeight() - 100) - forty_offset, p);
        canvas.drawText("" + 125, 0, (canvas.getHeight() - 100) - fifty_offset, p);
        canvas.drawText("" + 150, 0, (canvas.getHeight() - 100) - sixty_offset, p);
        canvas.drawText("" + 175, 0, (canvas.getHeight() - 100) - seventy_offset, p);
        canvas.drawText("" + 200, 0, (canvas.getHeight() - 100) - eighty_offset, p);
        canvas.drawText("" + 225, 0, (canvas.getHeight() - 100) - ninety_offset, p);
        canvas.drawText("" + 250, 0, (canvas.getHeight() - 100) - hundred_offset, p);
        canvas.drawText("" + 275, 0, (canvas.getHeight() - 100) - one_ten_offset, p);
        canvas.drawText("" + 300, 0, (canvas.getHeight() - 100) - one_two_offset, p);
        canvas.drawText("" + 325, 0, (canvas.getHeight() - 100) - one_three_offset, p);
        canvas.drawText("" + 350, 0, (canvas.getHeight() - 100) - one_four_offset, p);
        canvas.drawText("" + 375, 0, (canvas.getHeight() - 100) - one_five_offset, p);
        canvas.drawText("" + 400, 0, (canvas.getHeight() - 100) - one_six_offset, p);
        canvas.drawText("" + 425, 0, (canvas.getHeight() - 100) - one_seven_offset, p);
        canvas.drawText("" + 450, 0, (canvas.getHeight() - 100) - one_eight_offset, p);
        canvas.drawText("" + 475, 0, (canvas.getHeight() - 100) - one_nine_offset, p);
        canvas.drawText("" + 500, 0, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(canvas.getWidth()/10, canvas.getHeight() - 100, canvas.getWidth()/10, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine((canvas.getWidth()/10) * 2, canvas.getHeight() - 100, (canvas.getWidth()/10) * 2, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 3, canvas.getHeight() - 100, twenty * 3, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 4, canvas.getHeight() - 100, twenty * 4, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 5, canvas.getHeight() - 100, twenty * 5, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 6, canvas.getHeight() - 100, twenty * 6, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 7, canvas.getHeight() - 100, twenty * 7, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 8, canvas.getHeight() - 100, twenty * 8, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 9, canvas.getHeight() - 100, twenty * 9, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 10, canvas.getHeight() - 100, twenty * 10, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 11, canvas.getHeight() - 100, twenty * 11, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 12, canvas.getHeight() - 100, twenty * 12, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 13, canvas.getHeight() - 100, twenty * 13, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 14, canvas.getHeight() - 100, twenty * 14, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 15, canvas.getHeight() - 100, twenty * 15, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 16, canvas.getHeight() - 100, twenty * 16, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 17, canvas.getHeight() - 100, twenty * 17, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 18, canvas.getHeight() - 100, twenty * 18, (canvas.getHeight() - 100) - two_hun_offset, p);
        canvas.drawLine(twenty * 19, canvas.getHeight() - 100, twenty * 19, (canvas.getHeight() - 100) - two_hun_offset, p);
        for (int i = 0; i < points.size(); i++) {
            canvas.drawText("" + secondz.get(i), time.get(i), canvas.getHeight() - 75, x);
//            Log.v("X", "" + time.get(i));
            if (i < points.size() - 1) {
                canvas.drawCircle(time.get(i),(((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (avg / 525))) - 25), 25, r);
                canvas.drawLine(time.get(i), (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (avg / 525))) - 25), time.get(i + 1),
                        (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (avg / 525))) - 25), r);
                canvas.drawCircle(time.get(i), (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (points.get(i) / 525))) - 25), 25, p);
                canvas.drawLine(time.get(i), (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (points.get(i) / 525))) - 25), time.get(i + 1),
                        (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (points.get(i + 1) / 525))) - 25), p);
                if (stan_dev < 1) {
                    canvas.drawCircle(time.get(i),((canvas.getHeight() - 100) - 25), 25, b);
                    canvas.drawLine(time.get(i), ((canvas.getHeight() - 100) - 25), time.get(i + 1),
                            ((canvas.getHeight() - 100) + 20), b);
                } else if (stan_dev != 0) {
                    canvas.drawCircle(time.get(i),(((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (stan_dev / 525))) - 25), 25, b);
                    canvas.drawLine(time.get(i), (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (stan_dev / 525))) - 25), time.get(i + 1),
                            (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (stan_dev / 525))) - 25), b);
                }
//                Log.v("LIGHT_READING", "" + ((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (avg / 525))));
//                Log.v("20", "" + (canvas.getHeight() - (canvas.getHeight() * (20/80))));
//            } else if (i < points.size() - 1 && full == true) {
//                if (i >= 1) {
//                    canvas.drawCircle(time.get(i),(canvas.getHeight() - (canvas.getHeight() * (avg / 80))), 25, r);
//                    canvas.drawLine(time.get(i), (canvas.getHeight() - (canvas.getHeight() * (avg / 80))), time.get(i + 1),
//                            (canvas.getHeight() - (canvas.getHeight() * (avg / 80))), r);
//                    canvas.drawCircle(time.get(i), (canvas.getHeight() - (canvas.getHeight() * (points.get(i) / 80))), 25, p);
//                    canvas.drawLine(time.get(i), (canvas.getHeight() - (canvas.getHeight() * (points.get(i) / 80))), time.get(i + 1),
//                            (canvas.getHeight() - (canvas.getHeight() * (points.get(i + 1) / 80))), p);
//                    Log.v("LIGHT_READING", "" + (canvas.getHeight() - (canvas.getHeight() * (points.get(i) / 80))));
//                    Log.v("20", "" + (canvas.getHeight() - (canvas.getHeight() * (20/80))));
//
//                }
            } else {
                canvas.drawCircle(time.get(i),(((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (avg / 525))) - 20), 25, r);
                canvas.drawCircle(time.get(i), (((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (points.get(i) / 525))) - 25), 25, p);
                if (stan_dev < 1) {
                    canvas.drawCircle(time.get(i),((canvas.getHeight() - 100) - 25), 25, b);
                } else if (stan_dev != 0) {
                    canvas.drawCircle(time.get(i),(((canvas.getHeight() - 100) - ((canvas.getHeight() - 100) * (stan_dev / 525))) - 25), 25, b);
                }
            }
        }
    }


    public void addPoint(float f) {
        if (points.size() == 10) {
            points.set(0, f);
            points.remove(0);
            points.add(f);
            full = true;
        } else {
            points.add(f);
        }

    }

    public void addTime(float f) {
        if (time.size() == 10) {
            time.remove(0);
            time.add(f);
        } else {
            time.add(f);
        }

    }

    public void average(float total, float times) {
        light_total = total;
        total_times = times;
        avg = light_total/total_times;
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
