package com.example.animated_images

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
        val angry_kid_drawable =
            ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, R.drawable.angry_kid))
            animated_image.setImageDrawable(angry_kid_drawable)

            (angry_kid_drawable as AnimatedImageDrawable).start()


        } */

        val monkeyDrawable = ContextCompat.getDrawable(this, R.drawable.monkey_animated)
        animated_image.setImageDrawable(monkeyDrawable)
        (monkeyDrawable as AnimationDrawable).start()

    }
}
