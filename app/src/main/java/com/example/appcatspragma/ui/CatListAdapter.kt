package com.example.appcatspragma.ui

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcatspragma.data.model.Cat
import com.example.appcatspragma.databinding.CatsItemListBinding
import kotlinx.coroutines.withContext

class CatListAdapter(private val context: Context) : ListAdapter<Cat, CatListAdapter.CatViewHolder>(DiffCallback) {

    inner class CatViewHolder(
        private var binding: CatsItemListBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(cat: Cat) {
            binding.mtvTitle.text = cat.breedName
            binding.mtvOrigin.text = cat.origin
            binding.mtvIntelligenceLevel.text = cat.intelligence.toString()

            Glide.with(context)
                .load("")

        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Cat>() {

        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.breedName == newItem.breedName
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.breedName == newItem.breedName && oldItem.origin == newItem.origin
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}