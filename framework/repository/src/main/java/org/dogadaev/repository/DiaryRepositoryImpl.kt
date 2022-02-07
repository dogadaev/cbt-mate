package org.dogadaev.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import org.dogadaev.database.dao.DiariesDao
import org.dogadaev.database.entity.DiaryDB
import org.dogadaev.database.entity.DiaryWithEntries
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import org.dogadaev.repository.converter.toCommon
import org.dogadaev.repository.converter.toDB
import org.dogadaev.repository.converter.toUIModel
import org.dogadaev.repository.resource.ParametrizedResourceImpl
import org.dogadaev.repository.resource.ResourceImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiaryRepositoryImpl @Inject constructor(
    private val diariesDao: DiariesDao,
) : DiaryRepository {

    override val diariesResource = ResourceImpl {
        diariesDao.dairiesWithEntries.flowOn(Dispatchers.IO)
            .distinctUntilChanged()
            .mapLatest { dairies ->
                dairies.map(DiaryWithEntries::toUIModel)
            }
    }

    override val diaryResource = ParametrizedResourceImpl<Diary, String> { diaryId ->
        diariesDao.getDairyFlow(diaryId).flowOn(Dispatchers.IO)
            .distinctUntilChanged()
            .mapLatest(DiaryWithEntries::toUIModel)
    }

    override val entryResource = ParametrizedResourceImpl<List<Diary.Entry>, String> { diaryId ->
        diariesDao.getDiaryEntries(diaryId).flowOn(Dispatchers.IO)
            .distinctUntilChanged()
            .mapLatest { entries ->
                entries.map(DiaryDB.Entry::toCommon)
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