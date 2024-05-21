package com.example.translator.presentation.model.favouritesList

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemWordBinding

class WordFavouriteItem(
    private val binding: ItemWordBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: WordDB) {
        with(binding) {
            tvWord.text = word.word
        }
    }
}