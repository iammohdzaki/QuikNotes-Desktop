package data

import model.Note

object SampleData {

    fun getNotesList(): ArrayList<Note> {
        val notes = ArrayList<Note>()
        notes.add(
            Note(
                noteId = 1,
                noteTitle = "Test Note 1",
                noteBody = "this note contains info of note 1",
                creationTime = System.currentTimeMillis()
            )
        )
        notes.add(Note(noteId = 2, noteTitle = "Test Note 2", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 3, noteTitle = "Test Note 3", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 4, noteTitle = "Test Note 4", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 5, noteTitle = "Test Note 5", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 6, noteTitle = "Test Note 6", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 7, noteTitle = "Test Note 7", noteBody = "this note contains info of note 1"))
        notes.add(Note(noteId = 8, noteTitle = "Test Note 8", noteBody = "this note contains info of note 1"))
        return notes
    }

}