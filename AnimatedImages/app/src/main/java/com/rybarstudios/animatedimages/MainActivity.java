package com.rybarstudios.animatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_view);
        mImageView.setImageDrawable(getDrawable(R.drawable.space));
        ((AnimatedImageDrawable)mImageView.getDrawable()).start();


        mSpinner = findViewById(R.id.image_selector);
        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String         selectedText = mSpinner.getSelectedItem().toString();
                final String[] stringArray  = getResources().getStringArray(R.array.resource_list);

                if (selectedText.equals(stringArray[0])) {
                    mImageView.setImageDrawable(getDrawable(R.drawable.space));
                } else if (selectedText.equals(stringArray[1])) {
                    mImageView.setImageDrawable(getDrawable(R.drawable.gatsby));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Drawable drawable = mImageView.getDrawable();
                if(drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).start();
                } else if (drawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawable).start();
                }
            }
        });

    }
}
