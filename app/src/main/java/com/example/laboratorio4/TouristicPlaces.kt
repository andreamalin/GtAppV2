package com.example.laboratorio4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import com.example.laboratorio4.databinding.FragmentTouristicPlacesBinding

class TouristicPlaces : Fragment() {
    private var placetoshow: String? = "Xocomil" //default
    private lateinit var binding: FragmentTouristicPlacesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_touristic_places, container, false)

        val intent = Intent()
        placetoshow = intent.getStringExtra("place_chose")

        changeTextViews()

        binding.submitComment.setOnClickListener {
            view!!.findNavController().navigate(TouristicPlacesDirections.actionTouristicPlacesToComment())
        }

        return binding.root
    }


    //Shows actual info
    private fun changeTextViews(){

        //Changes title, subtitle and text depending on bundle String
        if (placetoshow == "Xocomil") {
            binding.placeName = getString(R.string.xocomil_title)
            binding.placeInfo = getString(R.string.xocomil_info)
            binding.placePhrase = getString(R.string.xocomil_phrase)
        } else if (placetoshow == "Semuc Champey") {
            binding.placeName = getString(R.string.semuc_title)
            binding.placeInfo = getString(R.string.semuc_champey_info)
            binding.placePhrase = getString(R.string.secum_champey_phrase)
        } else {
            binding.placeName = getString(R.string.rio_title)
            binding.placeInfo = getString(R.string.rio_dulce_info)
            binding.placePhrase = getString(R.string.rio_phrase)
        }
    }


}
