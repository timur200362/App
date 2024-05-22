package com.example.translator.presentation.model.wordList

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.translator.R
import com.example.translator.data.database.WordEntity
import com.example.translator.databinding.ItemWordBinding

class WordItem(
    private val binding: ItemWordBinding,
    private val itemClickListener: WordItemClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(word: WordEntity) {
        with(binding) {
            tvWord.text = word.word

            ivDelete.setOnClickListener {
                itemClickListener.onDeleteItemClicked(word)
            }
            ivFavorite.setOnClickListener {
                itemClickListener.onFavoriteIconClicked(word)
            }
            if (word.isFavorite) {
                ivFavorite.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        root.resources,
                        R.drawable.baseline_favorite_24,
                        null
                    )
                )
            } else {
                ivFavorite.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        root.resources,
                        R.drawable.baseline_favorite_border_20,
                        null
                    )
                )
            }

        }
    }
}