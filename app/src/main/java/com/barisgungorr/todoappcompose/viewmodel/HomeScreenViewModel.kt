package com.barisgungorr.todoappcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.barisgungorr.todoappcompose.datasource.NotesDaoRepository

class HomeScreenViewModel : ViewModel(){
    private val notesDaoRepository = NotesDaoRepository()
     var notesList = notesDaoRepository.getNotes()

    init {
        getNotes()
        notesList = notesDaoRepository.getNotes()
    }

    private fun getNotes() = notesDaoRepository.addNotes()


    fun searchNotes(searchKeyword:String) {
        notesDaoRepository.searchNotes(searchKeyword)
    }

   fun deleteNotes(noteId:Int) {
        notesDaoRepository.deleteNotes(noteId)
    }
}