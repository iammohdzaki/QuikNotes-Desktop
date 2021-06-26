@file:Suppress("FunctionName")

package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.defaultScrollbarStyle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.Note
import theme.sansFontBoldFamily
import theme.NoteColors
import theme.sansFontFamily
import java.time.format.TextStyle

@Composable
fun NoteDetailView(note: Note) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                color = NoteColors.detailsBg
            )
    ) {
        Header(note)
        Divider()
        ScrollableColumn(
            modifier = Modifier.weight(1f)
        ) {
            EditableBody(note.noteBody) {
                note.noteBody = it
            }
        }
    }
}

@Composable
fun Header(note: Note) {
    Row(
        modifier = Modifier.preferredHeight(70.dp)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = note.noteTitle,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = sansFontBoldFamily
            ),
        )
        Image(
            bitmap = imageFromResource(theme.Icons.favorite),
            colorFilter = ColorFilter.tint(NoteColors.grey),
            modifier = Modifier.preferredSize(25.dp)
                .padding(start = 10.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        HeaderIcon(Icons.Default.Delete)
        Spacer(
            modifier = Modifier.width(10.dp)
        )
    }

}

@Composable
private fun HeaderIcon(image: ImageVector) {
    Image(
        imageVector = image,
        colorFilter = ColorFilter(NoteColors.grey, BlendMode.SrcIn),
        modifier = Modifier.preferredSize(20.dp)
    )
}

@Composable
private fun EditableBody(noteBody: String, onUpdate: (String) -> Unit) {
    var body = remember { mutableStateOf(noteBody) }
    TextField(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
        value = body.value,
        textStyle = androidx.compose.ui.text.TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontFamily = sansFontFamily
        ),
        onValueChange = { it ->
            body.value = it
            onUpdate.invoke(it)
        },
        backgroundColor = NoteColors.detailsBg,
        maxLines = 100,
        activeColor = Color.White,
    )
}