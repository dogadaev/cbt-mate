package org.dogadaev.home.presentation

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.dogadaev.entity.Dairy
import org.dogadaev.home.databinding.FragmentHomeLayoutBinding
import org.dogadaev.presentation.viewmodel.HomeViewModel

class HomeViewInteractor(
    private val fragment: Fragment,
    private val binding: FragmentHomeLayoutBinding,
    private val viewModel: HomeViewModel,
) {
    private val context = fragment.requireContext()

    init {
        setupToolbar()
        setupRecycler()
        setupListeners()
    }

    private fun setupToolbar() {
        binding.title.text = "Home"
    }

    private fun setupRecycler() {
        val dairiesAdapter = DairiesAdapter(::onItemLongClickListener)

        binding.dairiesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dairiesAdapter
        }

        viewModel.data.observe(fragment.viewLifecycleOwner, dairiesAdapter::submitList)
    }

    private fun setupListeners() {
        binding.apply {
            addButton.setOnClickListener {
                viewModel.addTestItem()
            }
        }
    }

    private fun onItemLongClickListener(dairy: Dairy) {
        viewModel.removeTestItem(dairy)
    }
}