package com.example.kotlin_android_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_android_week8.databinding.ActivityMainBinding

/**
 * feature/1-main-activity
 * Create BottomNavigation
 * 
 */
class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, WbhanFragment())
            .commitAllowingStateLoss()

        viewBinding.navBottom.run{
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_wbham -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, WbhanFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_jaeeepp -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, JaeeeppFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_maddy -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, MaddyFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_arr -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, ArrFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_rdh -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, RDHFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_wbham
        }
    }
}