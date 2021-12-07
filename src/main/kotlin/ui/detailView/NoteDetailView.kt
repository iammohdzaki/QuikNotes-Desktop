@file:Suppress("FunctionName")

package ui.detailView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.Strings.NOTE_BODY
import utils.Strings.NOTE_HEADING
import data.model.Note
import theme.TextLight
import theme.sansFontFamily

@Composable
fun NoteDetailView(note: Note, onSave: (Note) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                color = MaterialTheme.colors.background
            )
    ) {
        DetailHeader(note) {
            onSave.invoke(note)
        }
        Divider(color = TextLight, thickness = 1.dp, modifier = Modifier.height(1.dp))
        EditableTitle(note) {
            note.noteTitle = it
        }
        EditableBody(note) {
            note.noteBody = it
        }
    }
}

@Composable
private fun EditableTitle(note: Note, onUpdate: (String) -> Unit) {
    val noteTitle = mutableStateOf(note.noteTitle)

    TextField(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        value = noteTitle.value,
        textStyle = androidx.compose.ui.text.TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontFamily = sansFontFamily,
            fontSize = 24.sp,
        ),
        placeholder = { Text(NOTE_HEADING) },
        onValueChange = { it ->
            noteTitle.value = it
            onUpdate.invoke(it)
        },
        maxLines = 1,
        singleLine = true,
    )
}


@Composable
private fun EditableBody(note: Note, onUpdate: (String) -> Unit) {
    val noteBody = mutableStateOf(note.noteBody)
    TextField(
        modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
        value = noteBody.value,
        textStyle = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontFamily = sansFontFamily,
            fontSize = 16.sp,
        ),
        placeholder = { Text(NOTE_BODY) },
        onValueChange = { it ->
            noteBody.value = it
            onUpdate.invoke(it)
        },
    )
}