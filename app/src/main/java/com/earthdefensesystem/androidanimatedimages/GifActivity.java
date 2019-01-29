package com.earthdefensesystem.androidanimatedimages;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class GifActivity extends AppCompatActivity {
    private ImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        gifImageView = findViewById(R.id.animation_list_image);

        final Drawable drawable;
        try {
            drawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.freshdance));
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
