package org.dogadaev.dailybuch.fragment.factory

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FragmentFactoryModule {

    @Binds abstract fun provideFragmentFactory(
        fragmentFactory: DefaultFragmentFactory
    ): FragmentFactory
}