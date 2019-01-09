package at.fh.swengb.stadlhofer.homeexercise2

import android.arch.persistence.room.*


@Dao
interface NoteDAO {
    @Insert
    fun insert(note: Note)

    @Query("SELECT * FROM Note")
    fun findAll(): List<Note>

    @Query("SELECT title FROM Note")
    fun findTitle(): List<String>

    @Update
    fun update(note: Note)
}


