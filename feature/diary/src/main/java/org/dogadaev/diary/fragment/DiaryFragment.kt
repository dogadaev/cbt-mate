package org.dogadaev.diary.fragment

import androidx.fragment.app.Fragment
import org.dogadaev.diary.R
import org.dogadaev.diary.databinding.FragmentDiaryLayoutBinding
import org.dogadaev.ui.extensions.viewBinding

class DiaryFragment : Fragment(R.layout.fragment_diary_layout) {

    private val binding by viewBinding(FragmentDiaryLayoutBinding::bind)
}