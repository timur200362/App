package com.example.translator.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//@Database(
//    entities = [WordDB::class],
//    version = 1,
//    autoMigrations = [
//
//    ])
////@TypeConverters(Converter::class)
//abstract class WordDatabase : RoomDatabase() {
//    abstract fun wordDao(): WordDao
//    companion object {
//        @Volatile
//        private var INSTANCE: WordDatabase? = null
//
//        fun getInstance(context: Context): WordDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    WordDatabase::class.java,
//                    "word_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}