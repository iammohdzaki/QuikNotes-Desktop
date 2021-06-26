import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import data.SampleData
import extensions.Strings
import theme.DarkColorPalette
import theme.LightColorPalette
import theme.typography
import ui.NoteDetailView
import ui.NotesSideView

fun main() = Window(
    title = Strings.APP_NAME,
    size = IntSize(1000, 720)
) {
    val darkTheme = savedInstanceState { true }
    MaterialTheme(
        colors = if (darkTheme.value) DarkColorPalette else LightColorPalette,
        typography = typography
    ) {
        notesApp()
    }
}

@Composable
private fun notesApp() {
    Row(
        modifier = Modifier.background(
            color = MaterialTheme.colors.surface
        ).fillMaxSize()
    ) {

        val notes = remember { SampleData.getNotesList() }

        NotesSideView(
            notes
        ) { note ->
            print(note.noteTitle)
        }

        NoteDetailView(notes[0])

    }
}