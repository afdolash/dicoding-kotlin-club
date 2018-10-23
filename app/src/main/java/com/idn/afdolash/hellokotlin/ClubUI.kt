package com.idn.afdolash.hellokotlin

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {

    companion object {
        val imgClub = 1
        val tvClub = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(16)

            imageView {
                id = imgClub
                setImageResource(R.drawable.img_barca)
            }.lparams(width = dip(50), height = dip(50))

            textView {
                id = tvClub
                text = "Barcelona"
            }.lparams(width = matchParent, height = wrapContent) {
                leftMargin = dip(16)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }

}