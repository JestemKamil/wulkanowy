import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration60 : Migration(59, 60) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MutedMessageSenders (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                author TEXT NOT NULL,
            )
        """.trimIndent())
    }
}
