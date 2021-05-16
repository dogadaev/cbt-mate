package org.dogadaev.repository

import kotlinx.coroutines.flow.map
import org.dogadaev.repository.converter.toDB
import org.dogadaev.repository.converter.toUIModel
import org.dogadaev.database.dao.DiariesDao
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import org.dogadaev.repository.converter.toCommon

class DiaryRepositoryImpl(
    private val diariesDao: DiariesDao,
) : DiaryRepository {

    override fun getDairiesFlow() = diariesDao.getDairiesWithEntries().map { dairies ->
        dairies.map { it.toUIModel() }
    }

    override fun getEntriesFlow(diaryId: String) = diariesDao.getDiaryEntries(diaryId).map { entries ->
        entries.map { it.toCommon() }
    }

    override fun saveDairy(diary: Diary) = diariesDao.saveDairies(diary.toDB())

    override fun saveEntry(entry: Diary.Entry) = diariesDao.saveEntry(entry.toDB())

    override fun removeDairy(diary: Diary) {
        diariesDao.deleteDiary(diary.toDB())
        diariesDao.deleteEntries(diary.id)
    }
}