package com.example.translator.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface WordDao {
    @Insert
    suspend fun insert(wordDB: WordDB)

    @Query("DELETE FROM WordDB WHERE wordId=:id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM WordDB")
    suspend fun getAll(): List<WordDB>

    @Query("SELECT * FROM WordDB WHERE favorite=1")
    suspend fun getFavourites(): List<WordDB>

    @Query("UPDATE WordDB SET favorite=1 WHERE wordId=:id")
    suspend fun insertToFavourites(id: Int)

    @Query("UPDATE WordDB SET favorite=0 WHERE wordId=:id")
    suspend fun deleteFromFavourites(id: Int)

//    @Transaction
//    suspend fun insertAndGetAll(wordDB: WordDB):List<WordDB> {
//        insert(wordDB)
//        getAll()
//    }
}