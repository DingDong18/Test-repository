package com.ondevop.expansetrack.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.ondevop.expansetrack.R
import com.ondevop.expansetrack.databinding.FragmentReceiptBinding


class ReceiptFragment : Fragment() {

    private lateinit var  binding : FragmentReceiptBinding
    val args: ReceiptFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiptBinding.inflate(layoutInflater)


        val currentUri = args.imageUri.toUri()
        Log.d("URI2", "$currentUri")

         binding.dialogImage.setImageURI(currentUri)

        return binding.root
    }


}