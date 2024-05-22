package com.example.translator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WordDB::class],
    version = 1,
    autoMigrations = [

    ])
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}