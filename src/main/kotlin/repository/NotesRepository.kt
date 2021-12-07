package repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.SampleData
import data.model.Note

class NotesRepository {

    var notesState: NotesState by mutableStateOf(initialState())
        private set

    /**
     * Initial State of Notes
     */
    private fun initialState(): NotesState {
        return NotesState(
            SampleData.getNotesList(),
            SampleData.getNotesList().first()
        )
    }

    fun onAddNote() {
        setState {
            copy(notes = notes, selectedNote = Note())
        }
    }

    fun onSaveNote(note: Note) {
        if (checkIfNoteExists(note)) {
            setState {
                notesState.updateNote(note) { it }
            }
        } else {
            setState {
                note.noteId = this.notes.last().noteId + 1
                copy(notes = notes + note, selectedNote = note)
            }
        }
    }

    fun onNoteSelectionChanged(note: Note) {
        setState {
            copy(notes = notes, selectedNote = note)
        }
    }

    private fun NotesState.updateNote(note: Note, transformer: (Note) -> Note): NotesState =
        copy(notes = notes.updateNote(note = note, transformer = transformer), selectedNote = note)

    private fun List<Note>.updateNote(note: Note, transformer: (Note) -> Note): List<Note> =
        map { if (it.noteId == note.noteId) transformer(note) else note }

    private fun checkIfNoteExists(note: Note): Boolean = notesState.notes.any { it.noteId == note.noteId }

    private inline fun setState(update: NotesState.() -> NotesState) {
        notesState = notesState.update()
    }

    data class NotesState(
        val notes: List<Note> = emptyList(),
        val selectedNote: Note
    )

}