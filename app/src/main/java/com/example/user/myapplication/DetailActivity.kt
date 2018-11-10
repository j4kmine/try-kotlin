package com.example.user.myapplication

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import java.util.*

class DetailActivity:AppCompatActivity(){
    private var name: String = ""
    private var info:String = ""
    private var image:String =""
    lateinit var nameTextView: TextView
    lateinit var infoTextView: TextView
    lateinit var images: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)

            images = imageView(R.drawable.ic_launcher_background).
                    lparams(width= wrapContent) {
                        padding = dip(20)
                        margin = dip(15)
                        height = 300
                    }
            nameTextView = textView{
                width = matchParent
                this.gravity = Gravity.CENTER

            }
            infoTextView = textView()



        }

        val intent = intent
        name = intent.getStringExtra("name")
        info = intent.getStringExtra("info")
        image = intent.getStringExtra("image")
        nameTextView.text = name
        infoTextView.text = info
        Picasso.get().load(image.toInt()).into(images);

    }
}