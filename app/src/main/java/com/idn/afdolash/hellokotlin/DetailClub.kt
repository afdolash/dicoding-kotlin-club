package com.idn.afdolash.hellokotlin

import android.accounts.AuthenticatorDescription
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    private var name: String = ""
    private var image: String = ""
    private var description: String = ""
    lateinit var tvClub: TextView
    lateinit var imgClub: ImageView
    lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        verticalLayout {
            lparams {
                width = matchParent
                height = matchParent
                gravity = Gravity.CENTER_HORIZONTAL
            }
            padding = dip(16)

            imgClub = imageView()
                .lparams(width = dip(50), height = dip(50))

            tvClub = textView()

            tvDescription = textView()
        }
    }
}