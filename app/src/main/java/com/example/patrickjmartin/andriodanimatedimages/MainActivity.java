package com.example.patrickjmartin.andriodanimatedimages;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.animated_imageView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Drawable drawable = ImageDecoder.
                            decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.fakerealcat));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageDrawable(drawable);
                        }
                    });
                    if(drawable instanceof AnimatedImageDrawable) {
                        ((AnimatedImageDrawable) drawable).start();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
