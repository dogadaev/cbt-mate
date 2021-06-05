package org.dogadaev.home.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import org.dogadaev.entity.Diary
import org.dogadaev.home.databinding.FragmentHomeLayoutBinding
import org.dogadaev.home.fragment.HomeFragment
import org.dogadaev.navigation.NavigationGraphScreen
import org.dogadaev.navigation.Navigator
import org.dogadaev.presentation.viewmodel.HomeViewModel

class HomeViewInteractor(
    private val fragment: HomeFragment,
    private val binding: FragmentHomeLayoutBinding,
    private val viewModel: HomeViewModel,
    private val navigator: Navigator,
) {

    init {
        setupToolbar()
        setupRecycler()
        setupListeners()
    }

    private fun setupToolbar() {
        binding.title.text = "Home"
    }

    private fun setupRecycler() {
        val dairiesAdapter = DairiesAdapter(
            onItemClicked = { diary ->
                navigator.navigate(NavigationGraphScreen.Diary(diary.id))
            },
            onItemLongClicked = { diary ->
                viewModel.removeTestItem(diary)
            }
        )

        binding.dairiesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dairiesAdapter
        }

        viewModel.data.observe(fragment.viewLifecycleOwner, dairiesAdapter::submitList)
    }

    private fun setupListeners() {
        binding.addButton.setOnClickListener {
            viewModel.addTestItem()
        }
    }

    private fun onItemLongClickListener(diary: Diary) {
        viewModel.removeTestItem(diary)
    }
}