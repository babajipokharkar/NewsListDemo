package com.sride.newsfeedapp.ui.main.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sride.newsfeedapp.databinding.FragmentNewsDetailBinding
import com.sride.newsfeedapp.ui.main.newsdetails.NewsDetailFragmentArgs


class NewsDetailFragment : Fragment() {

    private val args : NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsDetailBinding.inflate(inflater,container,false)

        val newsModel = args.newsItem
        binding.newsDetail = newsModel
        return binding.root
    }
}