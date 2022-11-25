package com.example.kotlin_android_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_android_week8.databinding.ActivityAddMemoBinding

class AddMemoActivity : AppCompatActivity() {
    private val viewBinding: ActivityAddMemoBinding by lazy {
        ActivityAddMemoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.sendButton.setOnClickListener(){
            val roomDb = AppDatabase!!.getInstance(this)
            if(viewBinding.title.length() != 0 && viewBinding.memoContent.length() != 0) {
                roomDb?.memoDao()?.insert(
                    Memo(
                        viewBinding.title.text.toString(),
                        viewBinding.memoContent.text.toString()
                    )
                )
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(this, "입력하지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}