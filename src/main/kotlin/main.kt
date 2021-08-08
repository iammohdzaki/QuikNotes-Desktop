import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowSize
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import data.SampleData
import extensions.Strings
import theme.LightThemeColors
import theme.typography
import ui.NoteDetailView
import ui.NotesSideView

fun main() = application {
    val state = rememberWindowState(size = WindowSize(1000.dp, 720.dp))
    Window(onCloseRequest = ::exitApplication, state = state, title = Strings.APP_NAME) {
        val darkTheme = remember { false }
        MaterialTheme(
            colors = LightThemeColors,
            typography = typography
        ) {
            notesApp()
        }
    }

}

@Composable
private fun notesApp() {
    Row(
        modifier = Modifier.background(
            color = MaterialTheme.colors.background
        ).fillMaxSize()
    ) {

        val notes = remember { SampleData.getNotesList() }

        NotesSideView(
            notes
        ) { note ->
            println(note.noteTitle)
        }

        NoteDetailView(notes[0])

    }
}