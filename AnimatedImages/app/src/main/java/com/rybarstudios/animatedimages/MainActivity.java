package com.rybarstudios.animatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_view);
        mImageView.setImageDrawable(getDrawable(R.drawable.space));
        ((AnimatedImageDrawable)mImageView.getDrawable()).start();

    }
}
