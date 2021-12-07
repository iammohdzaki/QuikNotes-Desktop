@file:Suppress("FunctionName")

package ui.sideView.itemView

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Note
import theme.sansFontFamily

@Composable
fun NoteItemView(note: Note, isSelected: Boolean = false, onClick: (Note) -> Unit) {
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
            .border(if (isSelected) 1.dp else ((-10).dp), Color.Gray, shape = MaterialTheme.shapes.medium),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                .toggleable(isSelected, onValueChange = {
                    onClick.invoke(note)
                })
        ) {
            Text(
                text = "Note Id : ${note.noteId}",
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