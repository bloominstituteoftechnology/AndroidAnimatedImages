package com.example.israel.androidanimatedimages;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AnimationDrawable animationDrawable = new AnimationDrawable();

        final ImageView mainImageView = findViewById(R.id.image_view_main);
        mainImageView.setTag(false); // paused

        final Spinner animationListSpinner = findViewById(R.id.spinner_animation_list);
        animationListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) animationListSpinner.getSelectedItem();
                String[] animationListStrs = getResources().getStringArray(R.array.array_animation_list);
                if (selectedItem.equals(animationListStrs[0])) { // animated gif
                    mainImageView.setImageDrawable(getDrawable(R.drawable.cat));
                    mainImageView.setTag(false); // set to stop
                    mainImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Drawable drawable = mainImageView.getDrawable();
                            if (drawable instanceof AnimatedImageDrawable) {
                                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable)drawable;
                                if ((Boolean)mainImageView.getTag()) { // playing
                                    animatedImageDrawable.stop();
                                    mainImageView.setTag(false);
                                } else {
                                    animatedImageDrawable.start();
                                    //animatedImageDrawable.setRepeatCount(1);
                                    mainImageView.setTag(true);
                                }
                            }
                        }
                    });
                } else if (selectedItem.equals(animationListStrs[1])) { // animated drawable
                    mainImageView.setImageDrawable(getDrawable(R.drawable.walking_duck));
                    mainImageView.setTag(false); // set to stop
                    mainImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Drawable drawable = mainImageView.getDrawable();
                            if (drawable instanceof AnimationDrawable) {
                                AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
                                if ((Boolean)mainImageView.getTag()) { // playing
                                    animationDrawable.stop();
                                    mainImageView.setTag(false);
                                } else {
                                    animationDrawable.start();
                                    mainImageView.setTag(true);
                                }
                            }
                        }
                    });
                } else if (selectedItem.equals(animationListStrs[2])) { // animated vector drawable
                    mainImageView.setImageDrawable(getDrawable(R.drawable.avd_singlefile_play_to_pause));
                    mainImageView.setTag(true); // set to play
                    mainImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if ((Boolean)mainImageView.getTag()) { // play
                                mainImageView.setImageDrawable(getDrawable(R.drawable.avd_singlefile_play_to_pause));
                                mainImageView.setTag(false);
                            } else {
                                mainImageView.setImageDrawable(getDrawable(R.drawable.avd_singlefile_pause_to_play));
                                mainImageView.setTag(true);
                            }
                            Drawable drawable = mainImageView.getDrawable();
                            if (drawable instanceof Animatable) {
                                Animatable animatable = (Animatable)drawable;
                                animatable.start();
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
