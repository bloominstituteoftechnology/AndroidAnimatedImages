package com.joshuahalvorson.androidanimatedimages;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnimationDrawableListFragment extends Fragment {
    private ImageView animatedDrawableImage;

    public AnimationDrawableListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.animation_drawable_list_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animatedDrawableImage = view.findViewById(R.id.animation_drawable);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animatedDrawableImage.setImageDrawable(getActivity().getDrawable(R.drawable.al_bladerunner_animation));
        final Drawable drawable = animatedDrawableImage.getDrawable();
        if(drawable instanceof AnimationDrawable){
            ((AnimationDrawable) drawable).start();
        }
    }
}
