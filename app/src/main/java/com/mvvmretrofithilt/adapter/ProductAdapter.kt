package com.mvvmretrofithilt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.mvvmretrofithilt.databinding.ProductItemBinding
import com.mvvmretrofithilt.model.ProductResponseItem
import javax.inject.Inject

class ProductAdapter @Inject constructor(): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    lateinit var context: Context
    inner class ViewHolder(val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductResponseItem){
            binding.apply {
                Glide.with(context).load(item.image).into(image)
                name.text = item.title
                price.text = item.price.toString()
                rating.rating = item.rating!!.toFloat()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    private val diffUtil = object : DiffUtil.ItemCallback<ProductResponseItem>(){
        override fun areItemsTheSame(
            oldItem: ProductResponseItem,
            newItem: ProductResponseItem
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: ProductResponseItem,
            newItem: ProductResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)
}