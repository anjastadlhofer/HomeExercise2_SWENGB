package at.fh.swengb.stadlhofer.homeexercise2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_note_list.*


class AddNoteActivity : AppCompatActivity() {

    annotation class ColumnInfo(val name: String)
    annotation class PrimaryKey
    annotation class Entity(val title: String)

    private lateinit var noteList: List<String>

    lateinit var db: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NotesRoomDatabase.getDatabase(this)

        noteList = db.noteDAO.findTitle()
    }

    fun saveNote(v: View) {

        val note = Note(m_txt_Title.text.toString(),m_txt_Content.text.toString())

        if(note.title in noteList)
        {
            db.noteDAO.update(note)
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }

        else
        {
            db.noteDAO.insert(note)
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }




    }


}
