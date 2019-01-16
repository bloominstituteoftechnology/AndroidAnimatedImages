package com.example.patrickjmartin.andriodanimatedimages;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
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

import java.io.IOException;


public class AnimatedGIF extends Fragment {

    private ImageView gifImageView;
    private static String title = "Animated Gif";

    public AnimatedGIF() {
        // Required empty public constructor
    }


    public static AnimatedGIF newInstance() {
        AnimatedGIF fragment = new AnimatedGIF();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animated_gi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gifImageView = view.findViewById(R.id.animated_gif_imageView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Drawable drawable = ImageDecoder.
                            decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.fakerealcat));

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            gifImageView.setImageDrawable(drawable);
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
