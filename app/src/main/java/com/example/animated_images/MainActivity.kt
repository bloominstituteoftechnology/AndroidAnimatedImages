package com.example.animated_images

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val drawableList = listOf(R.drawable.angry_kid, R.drawable.monkey_animated)
    var pointer =0
    fun incrementPointer() {
        pointer ++
        if (pointer >= drawableList.size) {
            pointer = 0
        }

    }

    fun decrementPointer() {
        pointer --
        if (pointer < 0 ) {
            pointer = drawableList.size -1
        }

    }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_next.setOnClickListener{
            incrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this,drawableList[pointer]))


        }

        button_previous.setOnClickListener{
            decrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this,drawableList[pointer]))


        }

        button_play.setOnClickListener {view ->
            when (pointer) {
                0 -> animateGif(drawableList[pointer], animated_image)
                1-> animateAnimationDrawable(drawableList[pointer],animated_image)

            }
            animateVectorDrawable(R.drawable.avd_anim,view as ImageView)

        }




    }
    private fun animateVectorDrawable(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()

    }

    private fun animateAnimationDrawable(id: Int,view: ImageView) {
        val monkeyDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(monkeyDrawable)
        (monkeyDrawable as AnimationDrawable).start()
    }

    private fun animateGif(id: Int, view: ImageView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val angry_kid_drawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources,id))

        view.setImageDrawable(angry_kid_drawable)

            (angry_kid_drawable as AnimatedImageDrawable).start()




        }
    }
}
