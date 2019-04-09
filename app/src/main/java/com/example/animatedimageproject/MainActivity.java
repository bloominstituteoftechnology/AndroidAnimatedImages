package com.example.animatedimageproject;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView playButton;
    ImageView gifView;
    Spinner gifSelector;
    boolean isPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifSelector = findViewById(R.id.gif_selector);
        playButton = findViewById(R.id.play_gif_button);
        gifView = findViewById(R.id.imageView_gif);
        isPlayButton = true;
        playButton.setImageDrawable(getDrawable(R.drawable.avd_play_to_pause));

        gifSelector.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        gifView.setImageDrawable(getDrawable(R.drawable.keanu));
                        break;
                    case 1:
                        gifView.setImageDrawable(getDrawable(R.drawable.cat));
                        break;
                    case 2:
                        gifView.setImageDrawable(getDrawable(R.drawable.super_dog));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Drawable drawable = gifView.getDrawable();


                isPlayButton = !isPlayButton;

                if(!isPlayButton){
                    playButton.setImageDrawable(getDrawable(R.drawable.avd_pause_to_play));
                    if (drawable instanceof AnimatedImageDrawable) {
                        ((AnimatedImageDrawable) drawable).start();
                    } else if (drawable instanceof AnimationDrawable) {
                        ((AnimationDrawable) drawable).start();
                    }
                }else{
                    playButton.setImageDrawable(getDrawable(R.drawable.avd_play_to_pause));
                    if (drawable instanceof AnimatedImageDrawable) {
                        ((AnimationDrawable) drawable).stop();
                    } else if (drawable instanceof AnimationDrawable) {
                        ((AnimationDrawable) drawable).stop();
                    }
                }

            }
        });

    }
}
