package com.example.translator.presentation.model.favouritesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.translator.data.database.WordEntity
import com.example.translator.databinding.ItemFavouritewordBinding
class WordFavouriteAdapter(
) : ListAdapter<WordEntity, WordFavouriteItem>(WordFavouriteDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordFavouriteItem =
        WordFavouriteItem(
            binding = ItemFavouritewordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: WordFavouriteItem, position: Int) {
        holder.onBind(this.getItem(position))
    }
}