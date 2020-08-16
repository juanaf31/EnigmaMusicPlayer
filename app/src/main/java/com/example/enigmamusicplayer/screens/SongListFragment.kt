package com.example.enigmamusicplayer.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.SongRecycleAdapter
import com.example.enigmamusicplayer.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_song_list.*


class SongListFragment : Fragment(),View.OnClickListener {
    val songViewModel by activityViewModels<SongViewModel>()
    lateinit var adapter: SongRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_recycleView.layoutManager = LinearLayoutManager(this.context)
        adapter = SongRecycleAdapter(songViewModel)
        song_recycleView.adapter = adapter

        songViewModel.songData.observe(viewLifecycleOwner,Observer{
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            fab -> {navController.navigate(R.id.action_listFragment_to_inputSongFragment)}
        }
    }

}
