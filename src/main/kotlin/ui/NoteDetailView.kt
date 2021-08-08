@file:Suppress("FunctionName")

package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.Note
import theme.TextLight
import theme.sansFontBoldFamily
import theme.sansFontFamily

@Composable
fun NoteDetailView(note: Note) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                color = MaterialTheme.colors.background
            )
    ) {
        Header(note)
        Divider(color = TextLight,)
        Row(
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
        modifier = Modifier.height(70.dp)
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
            contentDescription = "",
            bitmap = imageFromResource(theme.Icons.favorite),
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier.size(25.dp)
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
        contentDescription = "",
        imageVector = image,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
private fun EditableBody(noteBody: String, onUpdate: (String) -> Unit) {
    var body = remember { mutableStateOf(noteBody) }
    BasicTextField(
        modifier = Modifier.fillMaxSize().padding(20.dp),
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
    )
}