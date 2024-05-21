package com.example.translator.presentation.model.wordList

interface WordItemClickListener {
    fun onTextWordClicked(position: Int)
    fun onFavoriteIconClicked(position: Int)
}