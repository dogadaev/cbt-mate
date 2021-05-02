package org.dogadaev.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.dogadaev.common.extensions.viewBinding
import org.dogadaev.home.R
import org.dogadaev.home.databinding.FragmentHomeLayoutBinding
import org.dogadaev.home.presentation.HomeViewInteractor
import org.dogadaev.presentation.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment(R.layout.fragment_home_layout) {

    private val viewModel: HomeViewModel by viewModel()
    private val binding by viewBinding(FragmentHomeLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HomeViewInteractor(this, binding, viewModel)
    }
}