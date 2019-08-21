package com.example.androidanimatedimages

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

 @SuppressLint("WrongThread")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
              val gifDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, R.drawable.unicorn))
            animated_image.setImageDrawable(gifDrawable)
              (gifDrawable as AnimatedImageDrawable).start()

        }
     animated_image
    }}
}
