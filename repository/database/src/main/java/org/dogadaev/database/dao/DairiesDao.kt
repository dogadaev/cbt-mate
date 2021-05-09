package org.dogadaev.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.dogadaev.database.entity.DairyDB

@Dao
interface DairiesDao {

    @Query("SELECT * FROM dairydb")
    fun getDairies(): Flow<List<DairyDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDairies(vararg dairies: DairyDB)

    @Delete
    fun delete(dairy: DairyDB)
}