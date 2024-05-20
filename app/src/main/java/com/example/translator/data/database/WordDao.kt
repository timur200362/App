package com.example.translator.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//@Dao
//interface WordDao {
//    @Insert
//    suspend fun insert(wordDB: WordDB)
//
//    @Query("DELETE FROM WordDB WHERE id=:id")
//    suspend fun delete(id: Int)
//
//    @Query("SELECT * FROM WordDB WHERE favorite=1")
//    suspend fun getAll(): List<WordDB>
//}