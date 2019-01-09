package at.fh.swengb.stadlhofer.homeexercise2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [Note::class], version = 1)
abstract class NotesRoomDatabase : RoomDatabase() {
    abstract val noteDAO: NoteDAO
    companion object {
        fun getDatabase(context: Context): NotesRoomDatabase {
            return Room.databaseBuilder(context, NotesRoomDatabase::class.java, "note-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}