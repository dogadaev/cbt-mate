package org.dogadaev.home

import org.dogadaev.home.fragment.HomeFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val homeModule = module {
    fragment { HomeFragment(get()) }
}