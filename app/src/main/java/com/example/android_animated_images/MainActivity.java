package com.example.android_animated_images;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    boolean isplaying;
    ImageView playButtonImageView;
    ImageView imageView;
    RadioButton radioButtonGoron;
    RadioButton radioButtonLink;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //INITIALIZATION
        setContentView(R.layout.activity_main);
        radioButtonGoron = findViewById(R.id.radio_button_goron);
        radioButtonLink = findViewById(R.id.radio_button_link);
        radioGroup = findViewById(R.id.radio_group);
        imageView = findViewById(R.id.image_view);
        playButtonImageView = findViewById(R.id.play_button_image_view);
        radioButtonLink.setChecked(true); // default radio button checked
        imageView.setImageDrawable(getDrawable(R.drawable.link)); //default gif loaded
        isplaying = false; //give default value for toggleable boolean


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //when either radio button is pressed
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_playtopause));
                isplaying = false;
                Log.i("AppLog", "onCheckChanged Triggered");
            }
        });
        radioButtonGoron.setOnClickListener(new View.OnClickListener() { //change which gif is loaded
            @Override
            public void onClick(View view) {
                    imageView.setImageDrawable(getDrawable(R.drawable.goron));
            }
        });
        radioButtonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getDrawable(R.drawable.link));
            }
        });

        playButtonImageView.setOnClickListener(new View.OnClickListener() { //clicking the play/pause button
            @Override
            public void onClick(View view) {
                Drawable gifDrawable = imageView.getDrawable();
                if (gifDrawable instanceof AnimatedImageDrawable) { //handles either AnimatedImageDrawables (New type)
                    if (!isplaying) {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_playtopause));
                        Drawable playButtonDrawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) playButtonDrawable).start();
                        ((AnimatedImageDrawable) imageView.getDrawable()).start();
                    } else {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_pausetoplay));
                        Drawable playButtonDrawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) playButtonDrawable).start();
                        ((AnimatedImageDrawable) imageView.getDrawable()).stop(); //stop gif
                    }
                }
                else if (gifDrawable instanceof AnimationDrawable){ //or AnimationDrawable (Old type)
                    if (!isplaying) {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_playtopause));
                        Drawable playButtonDrawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) playButtonDrawable).start();
                        ((AnimationDrawable) imageView.getDrawable()).start();
                    } else {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_pausetoplay));
                        Drawable playButtonDrawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) playButtonDrawable).start();
                        ((AnimationDrawable) imageView.getDrawable()).stop(); //stop gif
                    }
                }
                isplaying = !isplaying; // toggle
            }
        });
    }
}
