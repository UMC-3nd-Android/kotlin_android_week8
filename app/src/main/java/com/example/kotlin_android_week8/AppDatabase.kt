package com.example.kotlin_android_week8

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase:RoomDatabase() {
    companion object{
        private var appDatabase:AppDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if(appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "week8-DB"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}