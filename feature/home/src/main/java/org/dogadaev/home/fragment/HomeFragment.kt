package org.dogadaev.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.dogadaev.home.databinding.FragmentHomeLayoutBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLayoutBinding.inflate(inflater)

        return binding?.root
    }
}