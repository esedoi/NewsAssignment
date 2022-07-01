package com.paul.newsassignment.homefragment

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paul.newsassignment.R
import com.paul.newsassignment.data.Item
import com.paul.newsassignment.databinding.ItemNewsBinding
import com.paul.newsassignment.databinding.ItemTitleBinding
import java.time.*

import java.util.*

class HomeAdapter :
    ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TITLE -> {
                TitleHolder(ItemTitleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ))
            }
            TYPE_NEWS -> {
                NewsHolder(
                    ItemNewsBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ))
            }
            else -> {
                throw ClassCastException("Unknown viewType $viewType")
            }
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is NewsHolder -> {
                holder.bind(getItem(position))
            }
            is TitleHolder -> {
                holder.bind(getItem(position))
            }

        }
    }


    class NewsHolder(private var binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Item) {
            bindImage(binding.newsImg, item.appearance?.thumbnail)
            binding.newsMainTitle.text = item.appearance?.mainTitle
            binding.newSubTitle.text = item.appearance?.subTitle
            binding.newsSubscript.text = item.appearance?.subscript
            if(item.extra?.created!=null) binding.newsTime.text = item.extra.created.let {
                LocalDateTime.ofEpochSecond(it.toLong(),
                    0,
                    ZoneOffset.UTC)
            }.toString()

        }
    }

    class TitleHolder(private var binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.itemTitleTitle.text = item.title
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        private const val TYPE_NEWS = 0x00
        private const val TYPE_TITLE = 0x01

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            "divider" -> TYPE_TITLE
            "news" -> TYPE_NEWS
            else -> {
                0
            }
        }
    }
}

fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imgView)
    }
}
