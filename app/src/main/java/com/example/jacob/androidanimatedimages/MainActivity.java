package com.example.jacob.androidanimatedimages;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PLAYING_FLAG = "playing_flag";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private static ViewPager mViewPager;
    private static boolean playing = false;

    private static ArrayList<Drawable> drawables = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(getDrawable(R.drawable.avd_anim_stop_to_play));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Drawable buttonDrawable;
                if (playing) {
                    buttonDrawable = getDrawable(R.drawable.avd_anim_play_to_stop);
                    playing = false;
                } else {
                    buttonDrawable = getDrawable(R.drawable.avd_anim_stop_to_play);
                    playing = true;
                }
                fab.setImageDrawable(buttonDrawable);
                if (buttonDrawable instanceof Animatable) {
                    ((Animatable) buttonDrawable).start();
                }
                mViewPager.performClick();
            }
        });
        drawables.add(getDrawable(R.drawable.rotating_earth_animation));
        drawables.add(getDrawable(R.drawable.rotating_earth_animation));
        try {
            drawables.add(ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.computer_blowup)));
        } catch (IOException e) {
            e.printStackTrace();
            drawables.add(getDrawable(R.color.colorAccent));
        }

//        drawables.add(getDrawable(R.drawable.rotating_earth));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int position = getArguments().getInt(ARG_SECTION_NUMBER);
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final ImageView imageView = (ImageView) rootView.findViewById(R.id.animated_image);
            mViewPager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable imageViewDrawable = imageView.getDrawable();
                    if (playing) {
                        if (imageViewDrawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) imageView.getDrawable()).stop();
                        } else if (imageViewDrawable instanceof AnimationDrawable) {
                            ((AnimationDrawable) imageView.getDrawable()).stop();
                        }
                    } else {
                        if (imageViewDrawable instanceof AnimationDrawable) {
                            ((AnimationDrawable) imageView.getDrawable()).start();
                        } else if (imageViewDrawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) imageView.getDrawable()).start();
                        }
                    }
                }
            });
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, position));
            final Drawable drawable = drawables.get(position - 1);
            imageView.setImageDrawable(drawable);
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) imageView.getDrawable()).start();
            } else if (drawable instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) imageView.getDrawable()).start();
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }


        @Override
        public int getCount() {
            //TODO change count to 2 below and get 2nd image to stop and start on 2nd tab.
            //TODO change count to 3 below and get 3rd image display on 3rd tab.  Possible hardware issue. May work on another computer or phone.
            return 1;
        }

    }
}
