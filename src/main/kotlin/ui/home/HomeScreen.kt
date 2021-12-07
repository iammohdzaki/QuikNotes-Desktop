package ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import repository.NotesRepository
import ui.detailView.NoteDetailView
import ui.sideView.NotesSideView

@ExperimentalMaterialApi
@Composable
fun homeScreen(repository: NotesRepository) {
    val notesState = repository.notesState

    Row(
        modifier = Modifier.background(
            color = MaterialTheme.colors.background
        ).fillMaxSize()
    ) {

        NotesSideView(
            notesState.notes,
            notesState.selectedNote,
            onNoteClicked = { note ->
                println(note.noteTitle)
                repository.onNoteSelectionChanged(note)
            },
            onAddClick = {
                repository.onAddNote()
            }
        )

        NoteDetailView(notesState.selectedNote) { note ->
            repository.onSaveNote(note)
        }
    }
}