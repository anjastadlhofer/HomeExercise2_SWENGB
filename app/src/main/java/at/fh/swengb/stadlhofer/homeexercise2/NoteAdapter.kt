package at.fh.swengb.stadlhofer.homeexercise2


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*


class NoteAdapter(): RecyclerView.Adapter<NoteViewHolder>() {
    private var noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return noteList.count()
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        viewHolder.bindItem(note)
    }

    fun updateList(newList: List<Note>) {
        noteList.clear()
        noteList.addAll(newList.toList())
        notifyDataSetChanged()
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Note) {
        itemView.m_txt_Title_item.text = note.title
        itemView.m_txt_Content_item.text = note.content
    }
}
