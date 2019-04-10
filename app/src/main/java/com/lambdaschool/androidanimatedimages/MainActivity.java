package com.lambdaschool.androidanimatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AnimatedImageDrawable animatedImageDrawable;
    private BottomNavigationView bottomNavigationView;
    private AnimationDrawable animationDrawable;
    private Drawable drawable;

    private boolean buttonAnimationEnded;
    private TextView mTextMessage;
    private ImageView imageView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            drawable = imageView.getDrawable();
            if (drawable instanceof AnimatedImageDrawable) {
                animatedImageDrawable = (AnimatedImageDrawable) drawable;
                if (animatedImageDrawable.isRunning())
                    animatedImageDrawable.stop();
            } else if (drawable instanceof AnimationDrawable) {
                animationDrawable = (AnimationDrawable) drawable;
                if (animationDrawable.isRunning())
                    animationDrawable.stop();
            }

            switch (item.getItemId()) {
                case R.id.navigation_gif:
                    mTextMessage.setText(R.string.title_gif);
                    imageView.setImageDrawable(getDrawable(R.drawable.starblown));
                    drawable = imageView.getDrawable();
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
                    if (buttonAnimationEnded)
                        animatedImageDrawable.start();
                    return true;
                case R.id.navigation_avd:
                    mTextMessage.setText(R.string.title_avd);
                    imageView.setImageDrawable(getDrawable(R.drawable.coyote));
                    drawable = imageView.getDrawable();
                    animationDrawable = (AnimationDrawable) drawable;
                    if (buttonAnimationEnded)
                        animationDrawable.start();
                    return true;
                case R.id.navigation_gif2:
                    mTextMessage.setText(R.string.title_gif2);
                    imageView.setImageDrawable(getDrawable(R.drawable.gomez_addams_trampoline));
                    drawable = imageView.getDrawable();
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
                    if (buttonAnimationEnded)
                        animatedImageDrawable.start();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        mTextMessage = findViewById(R.id.text_view);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        buttonAnimationEnded = false;
        final ImageView imageViewButton = findViewById(R.id.image_view_button);
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonAnimationEnded) {
                    imageViewButton.setImageDrawable(getDrawable(R.drawable.line_forms_circle));

                } else {
                    imageViewButton.setImageDrawable(getDrawable(R.drawable.circle_melts_line));
                }
                drawable = imageViewButton.getDrawable();
                ((AnimatedVectorDrawable) drawable).start();
                buttonAnimationEnded = !buttonAnimationEnded;

                drawable = imageView.getDrawable();
                if (drawable instanceof AnimatedImageDrawable) {
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
                    if (animatedImageDrawable.isRunning())
                        animatedImageDrawable.stop();
                    else
                        bottomNavigationView.setSelectedItemId(bottomNavigationView.getSelectedItemId());
                } else if (drawable instanceof AnimationDrawable) {
                    animationDrawable = (AnimationDrawable) drawable;
                    if (animationDrawable.isRunning())
                        animationDrawable.stop();
                    else
                        bottomNavigationView.setSelectedItemId(bottomNavigationView.getSelectedItemId());
                }

            }
        });
    }
}
