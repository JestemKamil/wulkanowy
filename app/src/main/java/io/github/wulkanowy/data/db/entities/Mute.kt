package io.github.wulkanowy.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Mutes")
data class Mute(
    @ColumnInfo(name = "author")
    val author: String,
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
