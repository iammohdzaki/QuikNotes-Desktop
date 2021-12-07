@file:Suppress("FunctionName")

package ui.sideView

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Note
import theme.*

@ExperimentalMaterialApi
@Composable
fun NotesSideView(
    notesList: List<Note>,
    selectedNote: Note,
    onNoteClicked: (note: Note) -> Unit,
    onAddClick : () -> Unit
) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(
                color = MaterialTheme.colors.background,
            )
            .border(
                border = BorderStroke(1.dp, color = TextLight),
            )
            .fillMaxHeight()
    ) {
        SideHeader()
        AddNote{
            onAddClick.invoke()
        }
        if (notesList.isNotEmpty()) {
            NoteListView(notesList,selectedNote) { note ->
                onNoteClicked.invoke(note)
            }
        } else {
            EmptySideView()
        }
    }

}

