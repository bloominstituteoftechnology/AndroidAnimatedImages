package com.jakeesveld.android_animatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
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
    ConstraintLayout parentLayout;
    Boolean pickup;
    ImageView imageViewBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        buttonAnimation = findViewById(R.id.button_animation);
        buttonGif = findViewById(R.id.button_gif);
        buttonVector = findViewById(R.id.button_vector);
        parentLayout = findViewById(R.id.parent_layout);
        imageViewBubble = findViewById(R.id.image_view_bubble);
        imageViewBubble.setVisibility(View.GONE);

        imageView.setImageDrawable(getDrawable(R.drawable.snoop_dogg));
        parentLayout.setBackground(getDrawable(R.drawable.compton_background));
        buttonGif.setChecked(true);
        refreshAnimation();
        pickup = false;

        buttonGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewBubble.setVisibility(View.GONE);
                buttonGif.setChecked(true);
                buttonAnimation.setChecked(false);
                buttonVector.setChecked(false);
                imageView.setImageDrawable(getDrawable(R.drawable.snoop_dogg));
                parentLayout.setBackground(getDrawable(R.drawable.compton_background));
                refreshAnimation();
            }
        });

        buttonAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewBubble.setVisibility(View.GONE);
                buttonAnimation.setChecked(true);
                buttonVector.setChecked(false);
                buttonGif.setChecked(false);
                imageView.setImageDrawable(getDrawable(R.drawable.goat));
                parentLayout.setBackground(getDrawable(R.drawable.pasture_background));
                refreshAnimation();
            }
        });

        buttonVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGif.setChecked(false);
                buttonVector.setChecked(true);
                buttonAnimation.setChecked(false);
                if (pickup) {
                    imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_ring_pickup));
                    imageViewBubble.setVisibility(View.VISIBLE);
                } else {
                    imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_pickup_ring));
                }
                parentLayout.setBackground(getDrawable(R.drawable.office_background));
                refreshAnimation();
            }
        });


    }

    public void refreshAnimation() {
        final Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        } else if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        } else if (drawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawable).start();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonVector.isChecked()) {
                        if (pickup) {
                            imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_pickup_ring));
                            imageViewBubble.setVisibility(View.GONE);
                        } else {
                            imageView.setImageDrawable(getDrawable(R.drawable.avd_anim_ring_pickup));
                            imageViewBubble.setVisibility(View.VISIBLE);
                        }
                        Drawable current = imageView.getDrawable();
                        ((AnimatedVectorDrawable) current).start();
                        pickup = !pickup;
                    }
                }
            });

        }
    }


}
