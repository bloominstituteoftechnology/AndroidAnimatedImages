package com.example.androidanimatedimages.acitivities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidanimatedimages.R
import com.example.androidanimatedimages.fragments.AnimatedDrawableFragment
import com.example.androidanimatedimages.fragments.AnimatedVectorFragment
import com.example.androidanimatedimages.fragments.GifFragment

class MainActivity : AppCompatActivity(), AnimatedDrawableFragment.OnFragmentInteractionListener,
    AnimatedVectorFragment.OnFragmentInteractionListener,
    GifFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //i could probably make just one fragment that would determine which kind  of drawable is being passed to it, but we're gonna
    //do it this way


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gifFragment = GifFragment()
        val animatedDrawableFragment = AnimatedDrawableFragment()
        val animatedVectorFragment = AnimatedVectorFragment()

    /*
            if we need a bundle...
    val bundle = Bundle()
        bundle.putString(ITEM_KEY, item.id)

        //fragment.arguments = bundle
        fragment.setArguments(bundle)
*/


            supportFragmentManager.beginTransaction()
                .replace(R.id.gif_frame, gifFragment)
                .replace(R.id.animated_drawable_frame, animatedDrawableFragment)
                .replace(R.id.animated_vector_frame, animatedVectorFragment)
                .commit()


    }
}
