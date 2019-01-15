package com.joshuahalvorson.androidanimatedimages;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;

public class AnimatedGifFragment extends Fragment {
    private ImageView gifImageView;

    public AnimatedGifFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.animated_gif_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gifImageView = view.findViewById(R.id.gif_image);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            Drawable drawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.bladerunner));
            gifImageView.setImageDrawable(drawable);
            if(drawable instanceof AnimatedImageDrawable){
                ((AnimatedImageDrawable) drawable).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
