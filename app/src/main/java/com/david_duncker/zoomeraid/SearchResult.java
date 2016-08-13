package com.david_duncker.zoomeraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;

//package uk.co.senab.photoview.sample;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;



/**
 * Created by david on 7/12/16.
 */
public class SearchResult extends Activity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Intent intent = getIntent();
        String address = intent.getStringExtra(MainActivity.sr_address);
        String StreetNumber1 = intent.getStringExtra(MainActivity.sr_num1);
        String StreetNumber2 = intent.getStringExtra(MainActivity.sr_num2);
        String preimg = intent.getStringExtra(MainActivity.sr_preimg);
        String img = intent.getStringExtra(MainActivity.sr_img);
        String postimg = intent.getStringExtra(MainActivity.sr_postimg);

        TextView q;

        q = (TextView) findViewById(R.id.title);
        q.setText(StreetNumber1 + " - " + StreetNumber2 + " " + address);

        q=(TextView) findViewById(R.id.pre_img);
        q.setText(preimg);

        final ImageView qq = (ImageView) findViewById(R.id.img);
        int qq_resID=getResources().getIdentifier(img, "drawable", getPackageName());
        ImageHandler image=new ImageHandler(getApplicationContext(),qq_resID,qq,400,400);
        /*qq.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }

        });*/
        qq.setOnTouchListener(new View.OnTouchListener() {
            float start=0;
            float stop=0;
            boolean double_click=false;
            float downX, downY;
            int scrollByX, scrollByY;
            float zoomFactor = 4;
            boolean zoomedOut = false;
            public boolean onTouch(View arg0, MotionEvent event) {

                float currentX, currentY;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        start=System.nanoTime();
                        double_click=true;
                        downX = event.getX();
                        downY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        double_click=false;
                        currentX = event.getX();
                        currentY = event.getY();
                        scrollByX = (int)(downX - currentX);
                        scrollByY = (int)(downY - currentY);
                        qq.scrollBy(scrollByX, scrollByY);
                        downX = currentX;
                        downY = currentY;
                        break;
                    case MotionEvent.ACTION_UP:
                        stop=System.nanoTime();
                        if (stop-start<800000000) {
                            if (double_click == true) {
                                if (zoomedOut) {
                                    qq.setScaleX(1);
                                    qq.setScaleY(1);
                                    zoomedOut = false;
                                } else {
                                    qq.setScaleX(zoomFactor);
                                    qq.setScaleY(zoomFactor);
                                    zoomedOut = true;
                                }

                            }
                        }
                        break;
                }

                return true;
            }
        });



            q=(TextView) findViewById(R.id.post_img);
        q.setText(postimg);


    }
}
