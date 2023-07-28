package com.mohammad.notetakingapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mohammad.notetakingapp.model.Note
import com.mohammad.notetakingapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application,private val  noteRepository: NoteRepository):AndroidViewModel(app) {

    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
           noteRepository.deleteNote(note)
        }
    }
    fun updateNote(note:Note){
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun getAllNotes()=noteRepository.getAllNote()

    fun searchNote(query:String?)=noteRepository.search(query)

}