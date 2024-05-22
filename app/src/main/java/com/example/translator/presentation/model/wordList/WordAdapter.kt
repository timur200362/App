package com.example.translator.presentation.model.wordList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.translator.data.database.WordEntity
import com.example.translator.databinding.ItemWordBinding
class WordAdapter(
    private val itemClickListener: WordItemClickListener
) : ListAdapter<WordEntity, WordItem>(WordDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordItem =
        WordItem(
            binding = ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener = itemClickListener
        )

    override fun onBindViewHolder(holder: WordItem, position: Int) {
        holder.onBind(this.getItem(position))
    }
}