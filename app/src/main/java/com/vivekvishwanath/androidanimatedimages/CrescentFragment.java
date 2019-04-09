package com.vivekvishwanath.androidanimatedimages;


import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
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
public class CrescentFragment extends Fragment {

    ImageView imageView;
    boolean isCrescent;

    public CrescentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crescent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        isCrescent = true;
        imageView = view.findViewById(R.id.crescent_image);
        imageView.setImageDrawable(getActivity().getDrawable(R.drawable.avd_crescent_to_full));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCrescent) {
                    imageView.setImageDrawable(getActivity().getDrawable(R.drawable.avd_crescent_to_full));
                    Drawable drawable = imageView.getDrawable();
                    if (drawable instanceof AnimatedVectorDrawable) {
                        ((AnimatedVectorDrawable) drawable).start();
                    }
                    isCrescent = !isCrescent;
                } else {
                    imageView.setImageDrawable(getActivity().getDrawable(R.drawable.avd_full_to_crescent));
                    Drawable drawable = imageView.getDrawable();
                    if (drawable instanceof AnimatedVectorDrawable) {
                        ((AnimatedVectorDrawable) drawable).start();
                    }
                    isCrescent = !isCrescent;
                }
            }
        });
    }

}
