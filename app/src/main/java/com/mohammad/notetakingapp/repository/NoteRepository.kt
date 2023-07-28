package com.mohammad.notetakingapp.repository

import com.mohammad.notetakingapp.database.NoteDatabase
import com.mohammad.notetakingapp.model.Note

class NoteRepository(private var db:NoteDatabase) {
    suspend fun insertNote(note:Note)=db.getNoteDao().insertNote(note)

    suspend fun deleteNote(note: Note)=db.getNoteDao().delete(note)

    suspend fun updateNote(note:Note)=db.getNoteDao().updateNote(note)

    fun getAllNote()=db.getNoteDao().getAllNote()

    fun search(query:String?)=db.getNoteDao().searchNote(query)
}