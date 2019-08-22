package com.example.androidanimatedimages

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

    val drawablesIds = listOf(R.drawable.edgif, R.drawable.warhammer_animated)
    var pointer = 0
    fun incrementPointer(){
        pointer++
        if (pointer < 0){
            pointer = drawablesIds.size - 1 
        }
    }
       fun decrementPointer() {
           pointer--
           if (pointer < 0) {
               pointer = drawablesIds.size - 1
           }
       }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_next.setOnClickListener {
            incrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this, drawablesIds[pointer]))

        }

        button_previous.setOnClickListener {
            decrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this,drawablesIds[pointer]))
        }


        button_play.setOnClickListener {view ->
            when(pointer){
                0 -> animateGif(drawablesIds[pointer], animated_image)
                1 -> animateAnimationDrawable(drawablesIds[pointer], animated_image)
            }
            animateVectorDraw(R.drawable.avd_anim,  view as ImageView)
        }

        //animateGif()
        //animateAnimationDrawable()

       // animateVectorDraw()

    }

    private fun animateVectorDraw(id: Int, view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

    private fun animateAnimationDrawable(id: Int, view: ImageView) {
        val frameDrawable = ContextCompat.getDrawable(this,id)
        view.setImageDrawable(frameDrawable)
        (frameDrawable as AnimationDrawable).start()
    }

    private fun animateGif(id: Int, view: ImageView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val gifDrawable = ImageDecoder.decodeDrawable(
                ImageDecoder.createSource(resources, id))
            view.setImageDrawable(gifDrawable)
            (gifDrawable as AnimatedImageDrawable).start()
        }
    }
}
