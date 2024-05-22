package com.example.translator.presentation.model.wordList

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemWordBinding

class WordItem(
    private val binding: ItemWordBinding,
    private val itemClickListener: WordItemClickListener
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: WordDB) {
        with(binding) {
            tvWord.text = word.word

            ivDelete.setOnClickListener {
                itemClickListener.onDeleteItemClicked(word.wordId)
            }
            ivFavorite.setOnClickListener {
                itemClickListener.onFavoriteIconClicked(word.wordId)
            }
        }
    }
}