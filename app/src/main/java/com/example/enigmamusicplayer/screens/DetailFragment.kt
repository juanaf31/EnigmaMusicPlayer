package com.example.enigmamusicplayer.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.utils.ConvertBitmap
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import java.util.*

class DetailFragment : Fragment() {
    val songViewModel by activityViewModels<SongViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title_detail.text = songViewModel.details["title"]
        ConvertBitmap(image_detail).execute(songViewModel.details["image"])
    }

}
