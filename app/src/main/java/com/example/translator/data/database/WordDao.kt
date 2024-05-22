package com.example.translator.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface WordDao {
    @Insert
    suspend fun insert(wordEntity: WordEntity)

    @Query("DELETE FROM words WHERE wordId=:id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM words")
    suspend fun getAll(): List<WordEntity>

    @Query("SELECT * FROM words WHERE favorite=1")
    suspend fun getFavourites(): List<WordEntity>

    @Query("UPDATE words SET favorite=1 WHERE wordId=:id")
    suspend fun insertToFavourites(id: Int)

    @Query("UPDATE words SET favorite=0 WHERE wordId=:id")
    suspend fun deleteFromFavourites(id: Int)

    @Transaction
    suspend fun insertToFavoriteAndGetAll(id: Int): List<WordEntity> {
        insertToFavourites(id)
        return getAll()
    }

    @Transaction
    suspend fun deleteFromFavoriteAndGetAll(id: Int): List<WordEntity> {
        deleteFromFavourites(id)
        return getAll()
    }

    @Transaction
    suspend fun deleteAndGetAll(id: Int): List<WordEntity> {
        delete(id)
        return getAll()
    }
}