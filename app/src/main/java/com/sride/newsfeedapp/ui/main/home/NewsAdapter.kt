package com.sride.newsfeedapp.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sride.newsfeedapp.api.NewsListModel
import com.sride.newsfeedapp.databinding.LayoutNewsRowBinding
import com.sride.newsfeedapp.ui.main.home.MainFragmentDirections


class NewsAdapter : PagedListAdapter<NewsListModel, NewsAdapter.ViewHolder>(
    DiffCallback()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.apply {
            bind(createOnClickListener( newsItem), newsItem)
            itemView.tag = newsItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutNewsRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    private fun createOnClickListener( newItem: NewsListModel?): View.OnClickListener {
        return View.OnClickListener {
            val direction =
                MainFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                    newItem ?: NewsListModel()
                )
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: LayoutNewsRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: NewsListModel?) {
            binding.apply {
                clickListener = listener
                newsItem = item
                executePendingBindings() }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<NewsListModel>() {

    override fun areItemsTheSame(oldItem: NewsListModel, newItem: NewsListModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsListModel, newItem: NewsListModel): Boolean {
        return oldItem == newItem
    }
}
