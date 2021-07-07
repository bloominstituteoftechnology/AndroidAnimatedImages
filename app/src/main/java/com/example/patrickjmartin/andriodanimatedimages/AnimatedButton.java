package com.example.patrickjmartin.andriodanimatedimages;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static com.example.patrickjmartin.andriodanimatedimages.R.drawable.time_switcher_anim_12;


public class AnimatedButton extends Fragment {

    private ImageView animatedButtonVector;
    private static String title = "Animated Vector";
    private boolean isNight = true;

    public AnimatedButton() {
        // Required empty public constructor
    }

    public static AnimatedButton newInstance() {
        AnimatedButton fragment = new AnimatedButton();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animated_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animatedButtonVector = view.findViewById(R.id.animated_button_imageView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        animatedButtonVector.setImageDrawable(getActivity()
                .getDrawable(R.drawable.time_switcher_anim_13));
        final Drawable drawable = animatedButtonVector.getDrawable();
        if(drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

        animatedButtonVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNight) {
                    animatedButtonVector.setImageDrawable(getActivity()
                            .getDrawable(time_switcher_anim_12));
                    isNight = false;
                } else {
                    animatedButtonVector.setImageDrawable(getActivity()
                            .getDrawable(R.drawable.time_switcher_anim_13));
                    isNight = true;
                }
                final Drawable drawable = animatedButtonVector.getDrawable();
                if(drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }

            }
        });
    }
}
