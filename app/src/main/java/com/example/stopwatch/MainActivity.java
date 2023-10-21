package com.example.stopwatch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int milliseconds = 0;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.timertextId);

        startTimer();
    }

    public void onclickStart(View view) {

        isRunning = true;

    }


    public void onclickStop(View view) {

        isRunning = false;


    }

    public void onclickReset(View view) {

        isRunning= false;
        milliseconds =0;

    }


    public void startTimer() {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                 // int ms = milliseconds%100 ; // milliseconds = 1,2...10 % 10 = 1...9(ans)
                 // int s =  milliseconds/60%60;//10/10=1...-> || For second= //(0,1,2,3...59,60)/60 ='x'-discrete =result/60 = (0,1,2,3...59)
                 // int m = milliseconds/3600;  //60/60 =1, 120/60 =2


               // int h = m/60; // or seconds/60*60


                int h= (milliseconds/216000) % 24;
                int m =(milliseconds /3600) % 60;
                int s =(milliseconds/60  % 60);
                int ms = milliseconds % 100;



                String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d:%02d" , h, m, s, ms);

                textView.setText(formatString);


                if (isRunning){
                    milliseconds++;
                }


                handler.postDelayed(this, 0);
            }
        });


    }




}