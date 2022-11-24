package com.example.kotlin_android_week8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_android_week8.databinding.FragmentJaeeeppBinding

class JaeeeppFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentJaeeeppBinding.inflate(layoutInflater).root
    }
}