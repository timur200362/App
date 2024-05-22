package com.example.translator.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity (
    @PrimaryKey(autoGenerate = true) val wordId: Int = 0,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "favorite") val isFavorite: Boolean = false
)
