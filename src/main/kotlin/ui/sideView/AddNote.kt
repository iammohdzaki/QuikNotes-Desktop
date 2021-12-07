package ui.sideView

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.Strings
import theme.sansFontFamily

@ExperimentalMaterialApi
@Composable
fun AddNote(onAddClick: () -> Unit) {
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
        backgroundColor = MaterialTheme.colors.secondary,
        onClick = {
            onAddClick.invoke()
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp, start = 6.dp, end = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = Strings.ADD_NOTE,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = sansFontFamily,
                    fontSize = 13.sp
                ),
                color = MaterialTheme.colors.onSurface
            )
        }

    }
}