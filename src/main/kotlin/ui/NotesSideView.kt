@file:Suppress("FunctionName")

package ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.materialIcon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.Strings
import model.Note
import theme.*

@Composable
fun NotesSideView(
    notesList: ArrayList<Note>,
    onNoteClicked: (note: Note) -> Unit
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
        Header()
        AddNote()
        NoteListView(notesList) { note ->
            onNoteClicked.invoke(note)
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}

@Composable
fun Header() {
    Row(
        modifier = Modifier.height(70.dp)
            .background(color = MaterialTheme.colors.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = Strings.MY_NOTES,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = sansFontFamily
            )
        )
    }
}

@Composable
fun AddNote() {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 8.dp,
                end = 8.dp
            ).fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp, start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = Strings.ADD_NOTE,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = sansFontFamily,
                    fontSize = 12.sp
                ),
                color = MaterialTheme.colors.onSurface
            )
        }

    }
}

@Composable
fun NoteListView(notesList: ArrayList<Note>, onNoteClicked: (note: Note) -> Unit) {
    LazyColumn {
        itemsIndexed(
            items = notesList
        ) { index, item ->
            NoteView(item) {
                onNoteClicked.invoke(item)
            }
        }
    }
}

@Composable
fun NoteView(note: Note, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = note.creationTime.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = sansFontFamily,
                    fontSize = 12.sp,
                ),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note.noteTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = sansFontFamily,
                    fontSize = 14.sp,
                ),
                color = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note.noteBody,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = sansFontFamily,
                    fontSize = 12.sp,
                ),
                maxLines = 4,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}