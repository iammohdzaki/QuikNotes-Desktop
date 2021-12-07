package ui.sideView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import utils.Strings
import theme.sansFontFamily

@Composable
fun SideHeader() {
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