package com.example.user.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private var items:MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()
//        list.layoutManager = LinearLayoutManager(this)
//        list.adapter = RecyclerViewAdapter(this, items)
        club_list.layoutManager = LinearLayoutManager(this)

        club_list.adapter = RecyclerViewAdapter(this, items,{item ->onclickme(item)  })

    }
    private fun onclickme(item: Item){
        startActivity(intentFor<DetailActivity>("name" to "${item.name}","info" to "${item.info}","image" to "${item.image}").singleTop())

    }
    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val info = resources.getStringArray(R.array.club_info)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],info[i],image.getResourceId(i,0)))

        }
        //Recycle the typed array
        image.recycle()
    }
}
