@file:Suppress("FunctionName")

package ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.Strings
import model.Note
import theme.DarkColorPalette
import theme.sansFontFamily
import theme.divider
import theme.sansFontBoldFamily

@Composable
fun NotesSideView(
    notesList: ArrayList<Note>,
    onNoteClicked: (note: Note) -> Unit
) {
    Column(
        modifier = Modifier
            .preferredWidth(250.dp)
            .background(
                color = MaterialTheme.colors.surface,
                shape = RectangleShape
            )
            .border(
                border = BorderStroke(1.dp, color = divider),
                shape = RectangleShape
            )
            .fillMaxHeight()
    ) {
        Header()
        Divider(color = divider)
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        NoteListView(notesList) { note ->
            onNoteClicked.invoke(note)
        }
    }

}

@Composable
fun Header() {
    Row(
        modifier = Modifier.preferredHeight(70.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = Strings.YOUR_NOTES,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = sansFontFamily
            )
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier.preferredSize(35.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = Icons.Default.Add,
                modifier = Modifier.preferredSize(25.dp),
                colorFilter = ColorFilter.tint(
                    color = Color.Black
                )
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
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 18.dp,
        backgroundColor = if(note.isSelected) DarkColorPalette.onSecondary else DarkColorPalette.onPrimary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
        ) {
            Box(
                modifier = Modifier.preferredSize(30.dp)
                    .background(
                        color = Color.Red,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = note.noteTitle.substring(0, 1).toUpperCase(),
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.Normal,
                        fontFamily = sansFontFamily,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = note.noteTitle,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.Normal,
                    fontFamily = sansFontFamily
                )
            )
        }
    }
}