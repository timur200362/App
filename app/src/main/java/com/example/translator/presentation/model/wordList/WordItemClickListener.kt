package com.example.translator.presentation.model.wordList

import com.example.translator.data.database.WordEntity

interface WordItemClickListener {
    fun onDeleteItemClicked(word: WordEntity)
    fun onFavoriteIconClicked(word: WordEntity)
}