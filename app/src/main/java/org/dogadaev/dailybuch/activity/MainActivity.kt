package org.dogadaev.dailybuch.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.dogadaev.dailybuch.databinding.ActivityMainBinding
import org.dogadaev.ui.extensions.viewBinding
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}