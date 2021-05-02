package org.dogadaev.home.presentation

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.dogadaev.home.databinding.FragmentHomeLayoutBinding
import org.dogadaev.presentation.viewmodel.HomeViewModel

class HomeViewInteractor(
    private val fragment: Fragment,
    private val binding: FragmentHomeLayoutBinding,
    private val viewModel: HomeViewModel,
) {
    private val context = fragment.requireContext()

    init {
        setupRecycler()
    }

    private fun setupRecycler() {
        val dairiesAdapter = DairiesAdapter()

        binding.dairiesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dairiesAdapter
        }

        viewModel.data.observe(fragment.viewLifecycleOwner, dairiesAdapter::submitList)
    }
}