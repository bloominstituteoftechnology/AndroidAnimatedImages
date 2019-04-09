package com.vivekvishwanath.androidanimatedimages;


import android.graphics.drawable.AnimatedImageDrawable;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class MonkeyFragment extends Fragment {

    ImageView imageView;

    public MonkeyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monkey, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.monkey_image);
        imageView.setImageDrawable(getActivity().getDrawable(R.drawable.monkey));
        Drawable drawable = imageView.getDrawable();

        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        } else if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }
}
