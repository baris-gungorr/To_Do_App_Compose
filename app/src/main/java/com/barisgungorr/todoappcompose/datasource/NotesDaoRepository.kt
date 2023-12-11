package com.barisgungorr.todoappcompose.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.barisgungorr.todoappcompose.data.Notes

class NotesDaoRepository {
    private var notesList = MutableLiveData<List<Notes>>()
    init {
        notesList = MutableLiveData()
    }
    fun getNotes(): MutableLiveData<List<Notes>> {
        return notesList
    }
    fun addNotes() {
        val list = mutableListOf<Notes>()
        val note1 = Notes(1, "Note 1", "This is note 1")
        val note2 = Notes(2, "Note 2", "This is note 2")
        list.add(note1)
        list.add(note2)
        notesList.value = list
    }

    fun searchNotes(searchKeyword:String) {
        Log.e("Notes Searching",searchKeyword)
    }

    fun addNewNotes(noteTitle:String,note:String) {
        Log.e("Notes Adding","$noteTitle $note")
    }

    fun updateNotes(noteId:Int,noteTitle:String,note:String) {
        Log.e("Notes Updating","$noteId $noteTitle $note")
    }
    fun deleteNotes(noteId:Int) {
        Log.e("Notes Deleting","$noteId")
    }
}