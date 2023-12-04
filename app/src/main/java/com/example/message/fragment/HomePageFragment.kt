package com.example.message.fragment

import android.os.Bundle
import android.util.Log.e
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.message.ChatRecyclerAdapter
import com.example.message.R
import com.example.message.base.BaseFragment
import com.example.message.data_model.ChatItem
import com.example.message.databinding.FragmentHomePageBinding
import com.example.message.view_model.FragmentViewModel

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    private val viewModel: FragmentViewModel by activityViewModels()
    private lateinit var adapter: ChatRecyclerAdapter
    private val chatItem: MutableList<Any> = mutableListOf()

    override fun start() {
        getJson()
        initAdapter()
    }

    override fun clickListener() {

    }

    private fun getJson() {

        val chatItemList: List<Map<String, Any>>? = viewModel.parseJsonFromRaw(resources, R.raw.chat_data)

        chatItemList?.forEach { chatItems ->

            chatItems.forEach {
                chatItem.add(it.value)
            }

        }

    }

    private fun initAdapter() = with(binding) {
        adapter = ChatRecyclerAdapter()
        rcChatItem.layoutManager = LinearLayoutManager(requireContext())
        rcChatItem.adapter = adapter

    }

}