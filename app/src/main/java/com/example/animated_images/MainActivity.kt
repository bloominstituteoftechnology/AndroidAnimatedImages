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

        button_play.setOnClickListener {
            when (pointer) {
                0 -> {animateGif(drawableList[pointer])}
                1-> {animateAnimationDrawable(drawableList[pointer])}

            }

        }


       // animateGif()

      //  animateAnimationDrawable()

    }

    private fun animateAnimationDrawable(id: Int) {
        val monkeyDrawable = ContextCompat.getDrawable(this, id)
        animated_image.setImageDrawable(monkeyDrawable)
        (monkeyDrawable as AnimationDrawable).start()
    }

    private fun animateGif(id: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val angry_kid_drawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources,id))

        animated_image.setImageDrawable(angry_kid_drawable)

            (angry_kid_drawable as AnimatedImageDrawable).start()


        }
    }
}
