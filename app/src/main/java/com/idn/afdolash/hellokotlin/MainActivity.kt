package com.idn.afdolash.hellokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Club> = mutableListOf()
    lateinit var rcClub: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            rcClub = recyclerView {
                clipToPadding = false
            }.lparams(width = matchParent)
        }

        rcClub.layoutManager = LinearLayoutManager(this)
        rcClub.adapter = ClubAdapter(this, items) {
            val intent = Intent(this, DetailClub::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("image", it.image)
            intent.putExtra("description", it.description)
            startActivity(intent)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)

        items.clear()

        for (i in name.indices) {
            items.add(Club(name[i], image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
}
