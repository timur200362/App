package com.example.translator.presentation.model

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.databinding.ItemWordBinding

class WordItem(
    private val binding: ItemWordBinding,
    private val action: (Word) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(wordsList: Word) {
        with(binding) {
            tvWord.text = wordsList.word

            root.setOnClickListener {
                action(wordsList)
            }
        }
    }
}