package com.idn.afdolash.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    private var name: String = ""
    private var image: Int = 0
    private var description: String = ""
    lateinit var tvClub: TextView
    lateinit var imgClub: ImageView
    lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            lparams {
                width = matchParent
                height = matchParent
            }
            padding = dip(16)

            imgClub = imageView()
                .lparams(width = dip(50), height = dip(50))

            tvClub = textView()
                .lparams(width = wrapContent) { gravity = Gravity.CENTER_HORIZONTAL }

            tvDescription = textView()
                .lparams(width = matchParent) { topMargin = dip(16) }
        }

        val intent = intent
        name = intent.getStringExtra("name")
        image = intent.getIntExtra("image", 0)
        description = intent.getStringExtra("description")

        tvClub.text = name
        tvDescription.text = description

//        val images = resources.obtainTypedArray(R.array.club_image)
//        imgClub.setImageResource(images.getResourceId(image, 0))

        Log.d("image", "link : $image")
    }
}