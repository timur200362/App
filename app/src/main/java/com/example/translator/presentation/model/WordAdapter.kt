package com.example.translator.presentation.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.translator.data.database.WordDB
import com.example.translator.databinding.ItemWordBinding
class WordAdapter(
    private val list: MutableList<WordDB>,
    private val itemClickListener: WordItemClickListener
) : RecyclerView.Adapter<WordItem>(){
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
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<WordDB>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()//difutills
    }
}
//class WordAdapter(
//    private val list: MutableList<WordDB>,
//    private val itemClickListener: WordItemClickListener
//) : ListAdapter<WordDB, WordItem>(WordDiffCallback()){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordItem =
//        WordItem(
//            binding = ItemWordBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            ),
//            itemClickListener = itemClickListener
//        )
//
//    override fun onBindViewHolder(holder: WordItem, position: Int) {
//        holder.onBind(list[position])
//    }
//
//    override fun getItemCount(): Int = list.size
//
//    fun update(newList: List<WordDB>) {
//        val callback = WordDiffCallback()
//        val diffResult = DiffUtil.calculateDiff(callback)
//        diffResult.dispatchUpdatesTo(this)
//        list.clear()
//        list.addAll(newList)
//    }
//}