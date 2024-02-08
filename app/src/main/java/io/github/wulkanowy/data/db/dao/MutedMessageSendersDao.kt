package io.github.wulkanowy.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.wulkanowy.data.db.entities.MutedMessageSender

@Dao
interface MutedMessageSendersDao : BaseDao<MutedMessageSender> {

    @Query("SELECT COUNT(*) FROM MutedMessageSenders WHERE author = :author AND user_id = :userId")
    suspend fun checkMute(author: String, userId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMute(mute: MutedMessageSender): Long

    @Query("DELETE FROM MutedMessageSenders WHERE author = :author AND user_id = :userId")
    suspend fun deleteMute(author: String, userId: Int)
}
