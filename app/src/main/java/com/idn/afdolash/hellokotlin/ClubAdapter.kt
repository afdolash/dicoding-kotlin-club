package com.idn.afdolash.hellokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ClubAdapter (private val context: Context, private val items: List<Club>, private val listener: (Club) -> Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ClubAdapter.ViewHolder, position: Int) = holder.bindItem(items[position], listener)


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        val tvItemClub = containerView.findViewById<TextView>(ClubUI.tvClub)
        val imgItemClub = containerView.findViewById<ImageView>(ClubUI.imgClub)

        fun bindItem (items: Club, listener: (Club) -> Unit) {
            tvItemClub.text = items.name
            items.image?.let { Picasso.get().load(it).into(imgItemClub) }

            itemView.setOnClickListener { listener(items) }
        }
    }
}