package org.dogadaev.diary.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import org.dogadaev.diary.databinding.FragmentDiaryLayoutBinding
import org.dogadaev.diary.fragment.DiaryFragment
import org.dogadaev.diary.fragment.DiaryFragmentArgs
import org.dogadaev.presentation.viewmodel.DiaryViewModel

class DiaryViewInteractor(
    private val fragment: DiaryFragment,
    private val binding: FragmentDiaryLayoutBinding,
    private val viewModel: DiaryViewModel,
) {

    init {
        setupToolbar()
        setupRecycler()
        setupListeners()
    }

    private fun setupToolbar() {
        binding.title.text = "Diary"
    }

    private fun setupRecycler() {
        val entriesAdapter = EntriesAdapter()

        binding.entriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = entriesAdapter
        }

        viewModel.data.observe(fragment.viewLifecycleOwner, entriesAdapter::submitList)
    }

    private fun setupListeners() {
        binding.addButton.setOnClickListener {
            viewModel.insertTestEntry()
        }
    }
}