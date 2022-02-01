package org.dogadaev.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.dogadaev.interactor.repository.DiaryRepository
import org.dogadaev.repository.DiaryRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDiaryRepository(
        diaryRepository: DiaryRepositoryImpl
    ): DiaryRepository
}