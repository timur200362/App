package com.example.translator.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [WordDB::class],
    version = 1,
    autoMigrations = [

    ])
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}