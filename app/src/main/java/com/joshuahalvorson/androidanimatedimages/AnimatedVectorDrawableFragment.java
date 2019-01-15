package com.joshuahalvorson.androidanimatedimages;


import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AnimatedVectorDrawableFragment extends Fragment {
    private ImageView animatedVectorDrawable;
    private boolean volumeOn = true;

    public AnimatedVectorDrawableFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animatedVectorDrawable = view.findViewById(R.id.animated_button);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        animatedVectorDrawable.setImageDrawable(getActivity().getDrawable(R.drawable.avd_anim_volume_off_volume_on));
        final Drawable drawable = animatedVectorDrawable.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }
        animatedVectorDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!volumeOn){
                    animatedVectorDrawable.setImageDrawable(getActivity().getDrawable(R.drawable.avd_anim_volume_off_volume_on));
                    volumeOn = true;
                }else{
                    animatedVectorDrawable.setImageDrawable(getActivity().getDrawable(R.drawable.avd_anim_volume_on_volume_off));
                    volumeOn = false;
                }
                final Drawable drawable = animatedVectorDrawable.getDrawable();
                if(drawable instanceof Animatable){
                    ((Animatable) drawable).start();
                }
            }
        });
    }
}
