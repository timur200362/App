package com.example.translator.presentation.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.translator.databinding.ItemWordBinding

class WordAdapter(
    private val list: MutableList<String>,
    private val action: (String) -> Unit
) : RecyclerView.Adapter<WordItem>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordItem =
        WordItem(
            binding = ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            action = action
        )

    override fun onBindViewHolder(holder: WordItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()//difutills
    }
}