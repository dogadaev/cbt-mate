package org.dogadaev.dairy

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.dogadaev.dairy.converter.toDB
import org.dogadaev.dairy.converter.toCommon
import org.dogadaev.database.dao.DairiesDao
import org.dogadaev.entity.Dairy
import org.dogadaev.interactor.repository.DairyRepository

class DairyRepositoryImpl(
    private val dairiesDao: DairiesDao
) : DairyRepository {

    override fun getDairiesFlow(): Flow<List<Dairy>> = dairiesDao.getDairies().map { dairies ->
        dairies.map { it.toCommon() }
    }

    override fun saveDairy(dairy: Dairy) = dairiesDao.saveDairies(dairy.toDB())

    override fun removeDairy(dairy: Dairy)  = dairiesDao.delete(dairy.toDB())
}