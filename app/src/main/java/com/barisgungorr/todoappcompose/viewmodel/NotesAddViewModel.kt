package com.barisgungorr.todoappcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.barisgungorr.todoappcompose.datasource.NotesDaoRepository

class NotesAddViewModel: ViewModel ()  {
    private val notesDaoRepository = NotesDaoRepository()

    fun addNewNotes(noteTitle:String,note:String) {
        notesDaoRepository.addNewNotes(noteTitle,note)
    }

}