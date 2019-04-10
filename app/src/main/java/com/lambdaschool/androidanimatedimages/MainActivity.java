package com.lambdaschool.androidanimatedimages;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AnimatedImageDrawable animatedImageDrawable;
    private AnimationDrawable animationDrawable;
    private Drawable drawable;

    private TextView mTextMessage;
    private ImageView imageView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

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
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_gif);
                    imageView.setImageDrawable(getDrawable(R.drawable.starblown));
                    drawable = imageView.getDrawable();
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
                    animatedImageDrawable.start();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_avd);
                    imageView.setImageDrawable(getDrawable(R.drawable.coyote));
                    drawable = imageView.getDrawable();
                    animationDrawable = (AnimationDrawable) drawable;
                    animationDrawable.start();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_gif2);
                    imageView.setImageDrawable(getDrawable(R.drawable.gomez_addams_trampoline));
                    drawable = imageView.getDrawable();
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
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
        drawable = imageView.getDrawable();
        animatedImageDrawable = (AnimatedImageDrawable) drawable;
        animatedImageDrawable.start();

        mTextMessage = findViewById(R.id.text_view);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
