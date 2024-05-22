package com.example.translator.presentation.model.favouritesList

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemFavouritewordBinding
class WordFavouriteItem(
    private val binding: ItemFavouritewordBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: WordDB) {
        with(binding) {
            tvFavouriteWord.text = word.word
        }
    }
}