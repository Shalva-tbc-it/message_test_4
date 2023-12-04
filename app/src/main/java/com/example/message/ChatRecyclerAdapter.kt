package com.example.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.message.data_model.ChatItem
import com.example.message.databinding.RecyclerChatItemBinding

class ChatRecyclerAdapter : ListAdapter<ChatItem, ChatRecyclerAdapter.ChatViewHolder>(object :
    DiffUtil.ItemCallback<ChatItem>() {
    override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            RecyclerChatItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind()
    }

    inner class ChatViewHolder(private val binding: RecyclerChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind() {
                val item = currentList[adapterPosition]


            }

    }

}