package org.dogadaev.dailybuch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import org.dogadaev.dailybuch.R
import org.dogadaev.dailybuch.databinding.ActivityMainBinding
import org.dogadaev.navigation.Navigator
import org.dogadaev.ui.extensions.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {

    private val navigator: Navigator by inject()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        navigator.navigationController = findNavController(R.id.navHost)
    }
}