package com.example.kotlin_android_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection.selectAll
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
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
            roomDb.memoDao().insert(Memo("db save check", "please!!!"))
            val savedMemo = roomDb.memoDao().selectAll()
            memoList.addAll(savedMemo)
        }

        val memoDataRVAdapter = MemoDataRVAdapter(memoList)

        viewBinding.rvMemoBox.adapter = memoDataRVAdapter
        viewBinding.rvMemoBox.layoutManager = LinearLayoutManager(this)

        viewBinding.btnNewMemo.setOnClickListener(){
            var intent = Intent(this, AddMemoActivity::class.java)
            startActivity(intent)
        }
    }
}