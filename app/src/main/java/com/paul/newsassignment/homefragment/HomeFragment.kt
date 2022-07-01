package com.paul.newsassignment.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paul.newsassignment.databinding.FragmentHomeBinding
import com.paul.newsassignment.getVmFactory


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeAdapter: HomeAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    private val homeViewModel by viewModels<HomeViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeAdapter = HomeAdapter()
        layoutManager = LinearLayoutManager(this.context)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = homeAdapter

        homeViewModel.news.observe(viewLifecycleOwner) {

            homeAdapter.submitList(it.getVector.items)
        }

        homeViewModel.getNews()

        return root
    }

}