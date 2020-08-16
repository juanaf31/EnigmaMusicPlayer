package com.example.enigmamusicplayer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel: ViewModel() {
    private val song:MutableList<MutableMap<String,String>>
            =
        mutableListOf(mutableMapOf(
            "name" to "Bara Suara",
            "title" to "Sendu Melagu",
            "image" to "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG"),
        mutableMapOf(
            "name" to "Danilla",
            "title" to "Berdistraksi",
            "image" to "https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"),
        mutableMapOf(
            "name" to ".feast",
            "title" to "Padi Milik Rakyat",
            "image" to "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2018/09/27/170962345.jpg"),
        mutableMapOf(
            "name" to "FourTwnty",
            "title" to "Nematomorpha",
            "image" to "https://pophariini.com/wp-content/uploads/2018/09/Fourtwnty.jpg"))
    val songData:MutableLiveData<MutableList<MutableMap<String,String>>> = MutableLiveData(song)
    val details:MutableMap<String,String> = mutableMapOf()
    fun addSong(name:String,title:String,image:String){
        var inputData:MutableMap<String,String> =
            mutableMapOf("name" to name,"title" to title,"image" to image)
        song.add(inputData)
        songData.value = song
    }

    fun detailSong(position:Int){
        val detail = song.get(position)
        details.put("name", detail["name"].toString())
        details.put("title",detail["title"].toString())
        details.put("image",detail["image"].toString())
    }
}