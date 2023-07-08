package com.kotlinegitim.kotlin_final.customadaptor

import android.app.Activity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.kotlinegitim.kotlin_final.R

class ToastCustomAdaptor{

    var act : Activity
    lateinit var image : ImageView
    lateinit var text_txt : TextView
    var Text_msg : String
    var imageid : Int
    var root : Int


    constructor(activity : Activity, view: Int, text_msg:String, Image : Int){

        act = activity
        root = view
        imageid= Image
        Text_msg = text_msg
    }

    fun showToast(){

        val layout = act.layoutInflater.inflate(root,null,true)
        image = layout.findViewById(R.id.custom_toast_image)
        text_txt= layout.findViewById(R.id.custom_toast_message)
        text_txt.text = Text_msg
        image.setImageResource(imageid)
        val myToast = Toast(act)
        myToast.duration = Toast.LENGTH_SHORT
        myToast.setGravity(Gravity.BOTTOM,0,0);
        myToast.view = layout
        myToast.show()
    }


}