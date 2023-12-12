package com.example.travelproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var currImg = 0
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.p0)

        val next = findViewById<ImageButton>(R.id.frwd)
        val prev = findViewById<ImageButton>(R.id.prev)

        next.setOnClickListener {
            updateImage(true)
        }

        prev.setOnClickListener {
            updateImage(false)
        }
    }

    private fun updateImage(isNext: Boolean) {
        image.alpha = 0f

        if (isNext) {
            currImg = (currImg + 1) % 5
        } else {
            currImg = (5 + currImg - 1) % 5
        }

        val idImageToShowString = "p$currImg"
        val idImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
        image = findViewById(idImageToShowInt)
        image.alpha = 1f
    }

}
