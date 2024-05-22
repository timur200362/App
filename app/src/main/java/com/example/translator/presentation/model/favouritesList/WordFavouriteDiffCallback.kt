package com.example.translator.presentation.model.favouritesList

import androidx.recyclerview.widget.DiffUtil
import com.example.translator.data.database.WordDB

class WordFavouriteDiffCallback: DiffUtil.ItemCallback<WordDB>() {
    override fun areItemsTheSame(oldItem: WordDB, newItem: WordDB): Boolean {
        return oldItem.wordId == newItem.wordId
    }

    override fun areContentsTheSame(oldItem: WordDB, newItem: WordDB): Boolean {
        return oldItem == newItem
    }
}