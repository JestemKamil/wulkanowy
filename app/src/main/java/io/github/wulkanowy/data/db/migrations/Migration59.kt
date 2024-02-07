package io.github.wulkanowy.data.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration59 : Migration(58, 59) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE Messages ADD COLUMN is_muted INTEGER NOT NULL DEFAULT 0")

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS Mutes (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                author TEXT NOT NULL,
                user_id INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())
    }
}
