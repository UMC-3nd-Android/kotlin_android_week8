package com.example.kotlin_android_week8

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_android_week8.databinding.ActivityFavoriteMemoBinding

class FavoriteMemoActivity : AppCompatActivity() {
    private val viewBinding:ActivityFavoriteMemoBinding by lazy {
        ActivityFavoriteMemoBinding.inflate(layoutInflater)
    }

    var memoList = mutableListOf<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val roomDb = AppDatabase!!.getInstance(this)

        val sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        if (roomDb != null) {
            val prefs = sharedPrefs.all
            for (i in prefs)
                memoList.add(roomDb.memoDao().selectByTitle(i.key.toString()))
        }

        val memoDataRVAdapter = MemoDataRVAdapter(this, memoList)

        viewBinding.rvMemoBox.adapter = memoDataRVAdapter
        viewBinding.rvMemoBox.layoutManager = LinearLayoutManager(this)

        viewBinding.btnBack.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}