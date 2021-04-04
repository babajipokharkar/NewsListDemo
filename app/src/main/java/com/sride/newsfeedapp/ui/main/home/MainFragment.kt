package com.sride.newsfeedapp.ui.main.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sride.newsfeedapp.api.Status
import com.sride.newsfeedapp.common.ConnectivityUtil
import com.sride.newsfeedapp.databinding.MainFragmentBinding
import com.sride.newsfeedapp.dependancyinjection.Injectable
import com.sride.newsfeedapp.dependancyinjection.injectViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment  : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel
    private var isConnected : Boolean = true
    private lateinit var  binding : MainFragmentBinding
    val newsViewModel : MainViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        isConnected = ConnectivityUtil.isConnected(context)
        if (!isConnected)
            Toast.makeText(context?.applicationContext,"No internet connection!",Toast.LENGTH_SHORT).show()

        val adapter = NewsAdapter()
        binding.rvNewsList.adapter = adapter
        subscribeUI(adapter)
    }

    private fun subscribeUI(adapter: NewsAdapter) {
        val data = viewModel.newsList(isConnected)
        data?.networkState?.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Status.RUNNING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.FAILED -> {
                    progressBar.visibility = View.GONE
                    // Handle fail state
                }
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                }
            }
        })
        data?.pagedList?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}
