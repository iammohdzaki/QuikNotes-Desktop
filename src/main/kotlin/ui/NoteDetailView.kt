@file:Suppress("FunctionName")

package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import extensions.formatCreatedDate
import model.Note
import theme.LatoFontBoldFamily
import theme.NoteColors

@Composable
fun NoteDetailView(note: Note) {
    Header(note)
}

@Composable
fun Header(note: Note) {
    Row(
        modifier = Modifier.preferredHeight(70.dp)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = note.noteTitle,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = LatoFontBoldFamily
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
    }

}