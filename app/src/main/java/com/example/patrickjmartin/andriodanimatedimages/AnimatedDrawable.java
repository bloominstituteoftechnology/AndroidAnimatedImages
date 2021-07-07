package com.example.patrickjmartin.andriodanimatedimages;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AnimatedDrawable extends Fragment {

    private ImageView animDrawableImageView;
    private static String title = "Animated Drawable";

    public AnimatedDrawable() {
        // Required empty public constructor
    }

    public static AnimatedDrawable newInstance() {
        AnimatedDrawable fragment = new AnimatedDrawable();
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
        return inflater.inflate(R.layout.fragment_animated_drawable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animDrawableImageView = view.findViewById(R.id.animated_drawable_imageview);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animDrawableImageView.setImageDrawable(getActivity()
                .getDrawable(R.drawable.list_spiderman_animation));
        final Drawable drawable = animDrawableImageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }
}
