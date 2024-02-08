import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration60 : Migration(59, 60) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE Messages ADD COLUMN is_muted INTEGER NOT NULL DEFAULT 0")
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MessageRecipientMutes (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                author TEXT NOT NULL,
                user_id INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent())
    }
}
