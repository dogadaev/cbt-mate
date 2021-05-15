package org.dogadaev.repository

import kotlinx.coroutines.flow.map
import org.dogadaev.repository.converter.toDB
import org.dogadaev.repository.converter.toUIModel
import org.dogadaev.database.dao.DairiesDao
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository

class DiaryRepositoryImpl(
    private val dairiesDao: DairiesDao,
) : DiaryRepository {

    override fun getDairiesFlow() = dairiesDao.getDairiesWithEntries().map { dairies ->
        dairies.map { it.toUIModel() }
    }

    override fun saveDairy(diary: Diary) = dairiesDao.saveDairies(diary.toDB())

    override fun removeDairy(diary: Diary) = dairiesDao.delete(diary.toDB())
}