package com.example.kotlin_android_week8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection.selectAll
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_android_week8.databinding.ActivityMainBinding
import com.example.kotlin_android_week8.databinding.ItemMemoListBinding

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

        val memoDataRVAdapter = MemoDataRVAdapter(this, memoList)
        val sharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        memoDataRVAdapter.setMyItemClickListener(object: MemoDataRVAdapter.MyItemClickListener {
            override fun onItemClick(memo: Memo) {

            }

            override fun onRemoveMemo(position: Int) {
                val memo = memoList[position]
                editor.remove(memo.title)
                editor.apply()
                Log.d("check", "mySharedPrefs is deleted.")
                roomDb?.memoDao()?.delete(memo)
                memoDataRVAdapter.removeItem(position)
            }
        })

        viewBinding.rvMemoBox.adapter = memoDataRVAdapter
        viewBinding.rvMemoBox.layoutManager = LinearLayoutManager(this)

        viewBinding.btnNewMemo.setOnClickListener(){
            var intent = Intent(this, AddMemoActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnFavorite.setOnClickListener(){
            var intent = Intent(this, FavoriteMemoActivity::class.java)
            startActivity(intent)
        }
    }
}