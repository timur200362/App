package com.example.translator.presentation.model.favouritesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemWordBinding
class WordFavouriteAdapter(
    private val list: MutableList<WordDB>,
) : RecyclerView.Adapter<WordFavouriteItem>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordFavouriteItem =
        WordFavouriteItem(
            binding = ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: WordFavouriteItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<WordDB>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}