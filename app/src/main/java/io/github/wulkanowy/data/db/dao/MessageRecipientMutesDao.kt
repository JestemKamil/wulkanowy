package io.github.wulkanowy.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.wulkanowy.data.db.entities.MessageRecipientMute

@Dao
interface MessageRecipientMutesDao : BaseDao<MessageRecipientMute> {

    @Query("SELECT COUNT(*) FROM MessageRecipientMutes WHERE author = :author AND user_id = :userId")
    suspend fun checkMute(author: String, userId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMute(mute: MessageRecipientMute): Long

    @Query("DELETE FROM MessageRecipientMutes WHERE author = :author AND user_id = :userId")
    suspend fun deleteMute(author: String, userId: Int)
}
