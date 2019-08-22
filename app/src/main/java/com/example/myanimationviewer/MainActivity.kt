package com.example.myanimationviewer

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var playing:Boolean =false
    val drawableIds = listOf(
        R.drawable.android_dance,
        R.drawable.coffee_animated
    )
    var pointer = 0
    fun incrementPointer() {
        pointer++
        if (pointer >= drawableIds.size) {
            pointer = 0
        }
    }

    fun decrementPointer() {
        pointer--
        if (pointer < 0) {
            pointer = drawableIds.size - 1
        }
    }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_next_image.setOnClickListener {
            incrementPointer()
            animated_image_view.setImageDrawable(
                ContextCompat.getDrawable(this, drawableIds[pointer])
            )
        }

        button_previous_image.setOnClickListener {
            decrementPointer()
            animated_image_view.setImageDrawable(
                ContextCompat.getDrawable(this, drawableIds[pointer])
            )
        }

        button_play.setOnClickListener { view ->

            if(!playing)
            {
                playing=true
                animateVectorDrawable(R.drawable.play_to_pause, view as ImageView)
                when(pointer) {
                    0 -> animateGif(drawableIds[pointer], animated_image_view)
                    1 -> animateAnimationDrawable(drawableIds[pointer], animated_image_view)
                }
            }
            else if(playing)
            {
                playing=false
                animateVectorDrawable(R.drawable.pause_to_play, view as ImageView)
                animated_image_view.setImageDrawable(
                    ContextCompat.getDrawable(this, drawableIds[pointer])
                )

            }

        }

    }

    private fun animateVectorDrawable(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

    private fun animateAnimationDrawable(id: Int, view: ImageView) {
        val frameDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(frameDrawable)
        (frameDrawable as AnimationDrawable).start()
    }

    private fun animateGif(id: Int, view: ImageView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val gifDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, id))
            view.setImageDrawable(gifDrawable)
            (gifDrawable as AnimatedImageDrawable).start()
        }
    }
}

