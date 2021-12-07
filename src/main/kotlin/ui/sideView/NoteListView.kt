@file:Suppress("FunctionName")

package ui.sideView

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Note
import ui.sideView.itemView.NoteItemView

@Composable
fun NoteListView(notesList: List<Note>,selectedNote: Note, onNoteClicked: (note: Note) -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {
        itemsIndexed(
            items = notesList
        ) { _, item ->
            NoteItemView(item, selectedNote.noteId == item.noteId) {
                onNoteClicked.invoke(item)
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}