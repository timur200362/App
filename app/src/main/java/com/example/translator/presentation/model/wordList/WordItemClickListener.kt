package com.example.translator.presentation.model.wordList

interface WordItemClickListener {
    fun onDeleteItemClicked(position: Int)
    fun onFavoriteIconClicked(position: Int)
}