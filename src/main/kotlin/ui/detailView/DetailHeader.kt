package ui.detailView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.Strings
import data.model.Note
import theme.Icons
import theme.sansFontFamily

@Composable
fun DetailHeader(note: Note, onSave: () -> Unit) {
    Row(
        modifier = Modifier.height(70.dp)
            .background(color = MaterialTheme.colors.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = Strings.MY_NOTES,
            color = MaterialTheme.colors.onPrimary,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontFamily = sansFontFamily,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(Icons.arrow),
            modifier = Modifier.size(10.dp),
            contentDescription = "",
            alignment = Alignment.Center,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = note.noteTitle,
            color = MaterialTheme.colors.onPrimary,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontFamily = sansFontFamily,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                onSave.invoke()
            },
        ) {
            Text(text = "Save")
        }
    }
}