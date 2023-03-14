package com.ondevop.expansetrack.fragment

import android.net.Uri
import android.os.Bundle
//import com.ondevop.expansetrack.MainFragmentDirections
import android.text.Layout.Directions
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ondevop.expansetrack.R
import com.ondevop.expansetrack.databinding.FragmentMainBinding
import com.ondevop.expansetracker.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


@AndroidEntryPoint
class MainFragment : Fragment() {
     private lateinit var  binding : FragmentMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)


        val uri =createImageUri()


        binding.fab.setOnClickListener {
            contract.launch(uri)
            viewModel.setImageUri(uri)
        }




        return binding.root
    }

    private val contract = registerForActivityResult(ActivityResultContracts.TakePicture()){

        if(it){

            val uri = viewModel.imageUri.value
            val curi = uri.toString()
            Log.d("URI", "(${curi}")
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToReceiptFragment(curi))
        }

    }

    fun createImageUri() : Uri {
        val image = File(requireContext().applicationContext.filesDir,"camera_photo.png")
        return FileProvider.getUriForFile(requireContext().applicationContext,
            "com.ondevop.expansetrack.fileProvider",
            image)
    }


}