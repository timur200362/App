package com.example.translator.presentation.model

import androidx.recyclerview.widget.RecyclerView
import com.example.translator.databinding.ItemWordBinding

class WordItem(
    private val binding: ItemWordBinding,
    private val action: (String) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: String) {
        with(binding) {
            tvWord.text = word

            root.setOnClickListener {
                action(word)
            }
        }
    }
}