package at.fh.swengb.stadlhofer.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNoteListActivityWithValues(v: View) {


        if(m_txt_Name.text.isEmpty())
            {
                m_txt_Name.setHint("Name eingeben!")

            }
        else if (m_txt_Age.text.isEmpty())
        {
            m_txt_Age.setHint("Alter eingeben!")
        }
        else
        {
            getSharedPreferences(packageName, Context.MODE_PRIVATE)

            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            sharedPreferences.edit().putString("Name", m_txt_Name.text.toString()).apply()
            sharedPreferences.edit().putInt("Age", m_txt_Age.text.toString().toInt()).apply()

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }



    }

}
