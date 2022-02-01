package org.dogadaev.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigatorModule {

    @Binds abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}