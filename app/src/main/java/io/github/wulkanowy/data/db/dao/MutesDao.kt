package io.github.wulkanowy.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.wulkanowy.data.db.entities.Mute

@Dao
interface MutesDao : BaseDao<Mute> {

    @Query("SELECT COUNT(*) FROM mutes WHERE author = :author AND user_id = :userId")
    suspend fun checkMute(author: String, userId: Long): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMute(mute: Mute): Long

    @Query("DELETE FROM mutes WHERE author = :author AND user_id = :userId")
    suspend fun deleteMute(author: String, userId: Long)
}
