package com.example.kotlin_android_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_android_week8.databinding.ActivityAddMemoBinding

class AddMemoActivity : AppCompatActivity() {
    private val viewBinding: ActivityAddMemoBinding by lazy {
        ActivityAddMemoBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

    }
}