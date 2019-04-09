package com.example.android_animated_images;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    boolean isplaying;
    ImageView playButtonImageView;
    ImageView imageView;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton = findViewById(R.id.radio_button);

        imageView = findViewById(R.id.image_view);
        imageView.setImageDrawable(getDrawable(R.drawable.link));

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked()){
                    imageView.setImageDrawable(getDrawable(R.drawable.goron));
                } else {
                    imageView.setImageDrawable(getDrawable(R.drawable.link));
                }
            }
        });




        isplaying = false;
        playButtonImageView = findViewById(R.id.play_button_image_view);
        playButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable gifDrawable = imageView.getDrawable();
                if (gifDrawable instanceof AnimatedImageDrawable) {
                    if (!isplaying) {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_playtopause));
                        Drawable drawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) drawable).start();
                        ((AnimatedImageDrawable) imageView.getDrawable()).start();
                    } else {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_pausetoplay));
                        Drawable drawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) drawable).start();
                        ((AnimatedImageDrawable) imageView.getDrawable()).stop(); //stop gif
                    }
                }
                else if (gifDrawable instanceof AnimationDrawable){
                    if (!isplaying) {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_playtopause));
                        Drawable drawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) drawable).start();
                        ((AnimationDrawable) imageView.getDrawable()).start();
                    } else {
                        playButtonImageView.setImageDrawable(getDrawable(R.drawable.avd_pausetoplay));
                        Drawable drawable = playButtonImageView.getDrawable();
                        ((AnimatedVectorDrawable) drawable).start();
                        ((AnimationDrawable) imageView.getDrawable()).stop(); //stop gif
                    }
                }

                isplaying = !isplaying; // toggle
            }
        });


    }
}
