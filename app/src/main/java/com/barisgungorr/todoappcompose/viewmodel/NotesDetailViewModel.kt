package com.barisgungorr.todoappcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.barisgungorr.todoappcompose.datasource.NotesDaoRepository

class NotesDetailViewModel: ViewModel() {
    private val notesDaoRepository = NotesDaoRepository()

    fun updateNotes(noteId:Int,noteTitle:String,note:String) {
        notesDaoRepository.updateNotes(noteId,noteTitle,note)
    }
}