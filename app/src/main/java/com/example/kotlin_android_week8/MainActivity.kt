package com.example.kotlin_android_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection.selectAll
import com.example.kotlin_android_week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    var memoList = mutableListOf<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val roomDb = AppDatabase!!.getInstance(this)

        if (roomDb != null) {
            val savedMemo = roomDb.memoDao().selectAll()
            memoList.addAll(savedMemo)
        }

        val memoDataRVAdapter = MemoDataRVAdapter(memoList)
    }
}