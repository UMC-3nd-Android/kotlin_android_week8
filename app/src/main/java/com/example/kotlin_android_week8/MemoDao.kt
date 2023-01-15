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
    fun selectAll(): List<Memo>

    @Query("SELECT * FROM Memo WHERE memoIdx = :memoIdx")
    fun selectByMemoIdx(memoIdx: Int): Memo

    @Query("SELECT * FROM Memo WHERE title = :title")
    fun selectByTitle(title: String): Memo

    @Query("SELECT * FROM Memo WHERE switch = :isOn")
    fun selectByFavorite(isOn: Boolean): MutableList<Memo>

    @Query("UPDATE Memo SET title = :title WHERE memoIdx = :memoIdx")
    fun updateTitleByMemoIdx(title:String, memoIdx: Int)

    @Query("UPDATE Memo SET content = :content WHERE memoIdx = :memoIdx")
    fun updateContentByMemoIdx(content:String, memoIdx: Int)

    @Query("UPDATE Memo SET switch = :isOn WHERE memoIdx = :memoIdx")
    fun updateFavoriteByMemoIdx(isOn: Boolean, memoIdx: Int)
}