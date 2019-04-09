package com.example.animatedimageproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView playButton;
    ImageView gifView;
    Spinner gifSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifSelector = findViewById(R.id.gif_selector);
        playButton = findViewById(R.id.play_gif_button);
        gifView = findViewById(R.id.imageView_gif);
    }
}
