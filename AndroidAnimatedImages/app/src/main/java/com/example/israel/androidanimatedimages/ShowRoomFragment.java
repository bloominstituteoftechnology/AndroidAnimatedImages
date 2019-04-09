package com.example.israel.androidanimatedimages;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowRoomFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowRoomFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_ROOM_NUMBER = "param1";

    private int showRoomNumber;

    private OnFragmentInteractionListener mListener;

    public ShowRoomFragment() {
        // Required empty public constructor
    }

    public static ShowRoomFragment newInstance(int showRoomNumber) {
        ShowRoomFragment fragment = new ShowRoomFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SHOW_ROOM_NUMBER, showRoomNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            showRoomNumber = getArguments().getInt(ARG_SHOW_ROOM_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        switch (showRoomNumber) {
            case 1: { // animated gif
                view = inflater.inflate(R.layout.fragment_show_room1, container, false);

            }break;
            case 2: { // animated drawable
                view = inflater.inflate(R.layout.fragment_show_room2, container, false);
                AnimationDrawable animationDrawable;
                // TODO
                //animationDrawable.addFrame();
            }break;
            case 3: { // animated vector drawable
                view = inflater.inflate(R.layout.fragment_show_room3, container, false);
//                final ImageButton imageButton = view.findViewById(R.id.fragment_show_room3_image_view);
//                imageButton.setTag(true); // isPlay
//                imageButton.setImageResource(R.drawable.avd_singlefile_play_to_pause);
//                ImageButton b = getActivity().findViewById(R.id.button_testing);
//                b.setImageResource(R.drawable.avd_singlefile_play_to_pause);
//
//                imageButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isPlay = (boolean)imageButton.getTag();
//                        if (isPlay) {
//                            imageButton.setImageResource(R.drawable.avd_singlefile_play_to_pause);
//                            imageButton.setTag(false); // set to pause
//                        } else {
//                            imageButton.setImageResource(R.drawable.avd_singlefile_pause_to_play);
//                            imageButton.setTag(true); // set to play
//                        }
//
//                        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) imageButton.getDrawable();
//                        avd.start();
//                    }
//                });
            }break;

            default: view = null;
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
