package at.fh.swengb.stadlhofer.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var db: NotesRoomDatabase
    private lateinit var adapter: NoteAdapter

    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val savedString = sharedPreferences.getString("Name", null)
        val savedInt = sharedPreferences.getInt("Age", -1)

        m_txt_NoteID.text = ("Notes for ${savedString}, ${savedInt}")

        // -----------------------------------------------------------------------

        db = NotesRoomDatabase.getDatabase(applicationContext)

        adapter = NoteAdapter()

        recycler_view_notes.layoutManager = LinearLayoutManager(this)
        recycler_view_notes.adapter = adapter

        adapter.updateList(db.noteDAO.findAll())

    }

    fun openAddNoteActivity(v: View) {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }
}
