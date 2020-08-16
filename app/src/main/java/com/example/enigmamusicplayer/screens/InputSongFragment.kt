package com.example.enigmamusicplayer.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_input_song.*


class InputSongFragment : Fragment(),View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            save_btn->{
                songViewModel.addSong(
                input_name.text.toString(),
                input_title.text.toString(),
                input_image.text.toString())
                Toast.makeText(v?.context,"Data Added", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
