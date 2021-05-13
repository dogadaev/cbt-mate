package org.dogadaev.dairy

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.dogadaev.dairy.converter.toDB
import org.dogadaev.dairy.converter.toCommon
import org.dogadaev.database.dao.DairiesDao
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository

class DiaryRepositoryImpl(
    private val dairiesDao: DairiesDao
) : DiaryRepository {

    override fun getDairiesFlow(): Flow<List<Diary>> = dairiesDao.getDairiesWithEntries().map { dairies ->
        // todo
        dairies.map { it.diary.toCommon() }
    }

    override fun saveDairy(diary: Diary) = dairiesDao.saveDairies(diary.toDB())

    override fun removeDairy(diary: Diary)  = dairiesDao.delete(diary.toDB())
}