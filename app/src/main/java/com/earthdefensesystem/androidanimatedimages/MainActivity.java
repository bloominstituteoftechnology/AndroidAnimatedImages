package com.earthdefensesystem.androidanimatedimages;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView animatedButton;
    private Button nextActivity, gifActivity;
    private boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatedButton = findViewById(R.id.image_button);
        nextActivity = findViewById(R.id.button);
        gifActivity = findViewById(R.id.button2);


        animatedButton.setImageDrawable(getDrawable(R.drawable.switch_vector_1));
        final Drawable drawable = (animatedButton).getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListVector.class);
                startActivity(i);
            }
        });
        gifActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GifActivity.class);
                startActivity(i);
            }
        });

        animatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    animatedButton.setImageDrawable(getDrawable(R.drawable.switch_vector_2));
                    isClicked = false;
                } else {
                    animatedButton.setImageDrawable(getDrawable(R.drawable.switch_vector_1));
                    isClicked = true;
                }
                final Drawable drawable = animatedButton.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
            }
        });
    }
}
