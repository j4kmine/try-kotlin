package com.example.user.myapplication

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.abc_alert_dialog_title_material.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(private val context:Context,private val items:List<Item>,val actionclick: (Item) -> Unit):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,p0,false))
    }


    override fun getItemCount():Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        (p0 as ViewHolder).bindItem(items[p1], actionclick)
    }

//    Plugin Android Extensions mendukung berbagai jenis container.
//    Yang paling mendasar adalah Activity, Fragment, dan View,
//    tetapi Anda juga dapat mengubah (virtual) kelas apa pun menjadi Android
//    Extensions container dengan menerapkan interface LayoutContainer.
//    Interface tersebut akan menyediakan sebuah view yang akan digunakan
//    untuk menemukan subviews. Bayangkan kita memiliki ViewHolder yang memegang tampilan
//    dengan tata letak seperti pada contoh ini. Dengan bantuan dari LayoutContainer, kode bisa lebih disederhanakan seperti:
    class ViewHolder(override  val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItem(items: Item,clickListener: (Item) -> Unit){
            itemView.name.text = items.name
            items.image?.let { Picasso.get().load(it).into(image) }
            containerView.setOnClickListener { clickListener(items) }
        }

    }
//    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
//        private val name = view.findViewById<TextView>(R.id.name);
//        private val image = view.findViewById<ImageView>(R.id.image);
//        fun bindItem(items:Item){
//            name.text =items.name;
//            items.image?.let { Picasso.get().load(it).into(image) }
//        }
//
//    }
}