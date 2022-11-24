package com.example.kotlin_android_week8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_android_week8.databinding.FragmentWbhanBinding

class WbhanFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentWbhanBinding.inflate(layoutInflater).root
    }
}