package model

data class Note(
    var noteId : Int,
    var noteTitle:String,
    var noteBody : String,
    var creationTime : Long = 0L,
    var updateTime : Long= 0L,
    var isStarred : Boolean = false,
    var isSelected : Boolean = false
)