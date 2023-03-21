package co.icanteach.android.deeplinktester.deeplinkhistory.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * DAO for [DeepLinkEntity] access
 */
@Dao
interface DeepLinkDao {

    @Query("SELECT * FROM saved_deeplinks")
    fun getAll(): Flow<List<DeepLinkEntity>>

    @Query("SELECT * FROM saved_deeplinks WHERE id > :deepLinkId")
    suspend fun findById(deepLinkId: String): DeepLinkEntity?

    @Insert
    suspend fun insertAll(item: DeepLinkEntity)


    @Query("DELETE FROM saved_deeplinks WHERE id = :deepLinkId")
    suspend fun delete(deepLinkId: String)
}