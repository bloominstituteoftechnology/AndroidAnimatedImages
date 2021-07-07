package com.earthdefensesystem.androidanimatedimages;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ListVector extends AppCompatActivity {
    private ImageView animatedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vector);
        animatedImageView = findViewById(R.id.animation_list_image);

        animatedImageView.setImageDrawable(getDrawable(R.drawable.dance_animation_list));
        final Drawable drawable = animatedImageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }
}
