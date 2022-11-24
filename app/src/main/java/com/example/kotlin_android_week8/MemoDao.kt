package com.example.kotlin_android_week8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("SELECT * FROM Memo")
    fun selectAll()

    @Query("SELECT * FROM Memo WHERE memoIdx = :memoIdx")
    fun selectByMemoIdx(memoIdx: Int)

    @Query("UPDATE Memo SET title = :title WHERE memoIdx = :memoIdx")
    fun updateTitleByMemoIdx(title:String, memoIdx: Int)

    @Query("UPDATE Memo SET content = :content WHERE memoIdx = :memoIdx")
    fun updateContentByMemoIdx(content:String, memoIdx: Int)
}