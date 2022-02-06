package org.dogadaev.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext
import org.dogadaev.repository.converter.toDB
import org.dogadaev.repository.converter.toUIModel
import org.dogadaev.database.dao.DiariesDao
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import org.dogadaev.interactor.resource.ParametrizedResource
import org.dogadaev.repository.converter.toCommon
import org.dogadaev.repository.resource.ParametrizedResourceImpl
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diariesDao: DiariesDao,
) : DiaryRepository {

    override val diaries = diariesDao.dairiesWithEntries
        .mapLatest { dairies ->
            dairies.map { it.toUIModel() }
        }

    override val diaryResource = ParametrizedResourceImpl<Diary, String> { diaryId ->
        diariesDao.getDairyFlow(diaryId).map {
            it.toUIModel()
        }
    }

    override val entryResource = ParametrizedResourceImpl<List<Diary.Entry>, String> { diaryId->
        diariesDao.getDiaryEntries(diaryId).map { entries ->
            entries.map { it.toCommon() }
        }
    }

    override suspend fun saveDairy(diary: Diary) = withContext(Dispatchers.IO) {
        diariesDao.saveDairies(diary.toDB())
    }

    override suspend fun saveEntry(entry: Diary.Entry) = withContext(Dispatchers.IO) {
        diariesDao.saveEntry(entry.toDB())
    }

    override suspend fun removeDairy(diary: Diary) = withContext(Dispatchers.IO) {
        diariesDao.deleteDiary(diary.toDB())
        diariesDao.deleteEntries(diary.id)
    }
}