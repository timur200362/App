package com.example.translator.presentation.model.wordList

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemWordBinding

class WordItem(
    private val binding: ItemWordBinding,
    //private val action: (Int) -> Unit,
    private val itemClickListener: WordItemClickListener
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: WordDB) {
        with(binding) {
            tvWord.text = word.word

            tvWord.setOnClickListener {
                itemClickListener.onTextWordClicked(word.wordId)
            }
            ivFavorite.setOnClickListener {
                itemClickListener.onFavoriteIconClicked(word.wordId)
            }
        }
    }
}