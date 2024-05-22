package com.example.translator.presentation.model.favouritesList

import androidx.recyclerview.widget.DiffUtil
import com.example.translator.data.database.WordEntity

class WordFavouriteDiffCallback: DiffUtil.ItemCallback<WordEntity>() {
    override fun areItemsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean {
        return oldItem.wordId == newItem.wordId
    }

    override fun areContentsTheSame(oldItem: WordEntity, newItem: WordEntity): Boolean {
        return oldItem == newItem
    }
}