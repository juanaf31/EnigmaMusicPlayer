package com.example.enigmamusicplayer.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.Exception
import java.net.URL

 class ConvertBitmap(internal val imageView: ImageView): AsyncTask<String, Void, Bitmap?>(){
    override fun doInBackground(vararg url: String): Bitmap? {
        val urlOfImage = url[0]
        println(urlOfImage)
        return try{
            val inputStream = URL(urlOfImage).openStream()
            BitmapFactory.decodeStream(inputStream)
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    override fun onPostExecute(result: Bitmap?) {
        if(result != null){
            imageView.setImageBitmap(Bitmap.createScaledBitmap(result,130,110,false))
        }
    }
}