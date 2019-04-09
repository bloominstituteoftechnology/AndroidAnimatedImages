package com.jakeesveld.android_animatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    RadioButton buttonGif;
    RadioButton buttonAnimation;
    RadioButton buttonVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        buttonAnimation = findViewById(R.id.button_animation);
        buttonGif = findViewById(R.id.button_gif);
        buttonVector = findViewById(R.id.button_vector);

        imageView.setImageDrawable(getDrawable(R.drawable.snoop_dogg));
        buttonGif.setChecked(true);
        refreshAnimation();

        buttonGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGif.setChecked(true);
                buttonAnimation.setChecked(false);
                buttonVector.setChecked(false);
                imageView.setImageDrawable(getDrawable(R.drawable.snoop_dogg));
                refreshAnimation();
            }
        });

        buttonAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAnimation.setChecked(true);
                buttonVector.setChecked(false);
                buttonGif.setChecked(false);
                imageView.setImageDrawable(getDrawable(R.drawable.goat));
                refreshAnimation();
            }
        });

        buttonVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGif.setChecked(false);
                buttonVector.setChecked(true);
                buttonAnimation.setChecked(false);
                imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_get_up));
                refreshAnimation();
            }
        });


    }

    public void refreshAnimation(){
        Drawable drawable = imageView.getDrawable();
        if(drawable instanceof AnimatedImageDrawable){
            ((AnimatedImageDrawable) drawable).start();
        }else if(drawable instanceof AnimationDrawable){
            ((AnimationDrawable) drawable).start();
        }else if(drawable instanceof AnimatedVectorDrawable){
            ((AnimatedVectorDrawable) drawable).start();

        }
    }



}
