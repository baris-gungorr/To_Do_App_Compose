package com.barisgungorr.todoappcompose.screen.notesdetailscreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.barisgungorr.todoappcompose.data.Notes
import com.barisgungorr.todoappcompose.R
import com.barisgungorr.todoappcompose.viewmodel.NotesAddViewModel
import com.barisgungorr.todoappcompose.viewmodel.NotesDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteDetailScreen(getNote: Notes) {
    val noteTitle = remember{ mutableStateOf("") }
    val note = remember{ mutableStateOf("") }
    val viewModel: NotesDetailViewModel = viewModel()


    LaunchedEffect(key1 = true) {
        noteTitle.value = getNote.noteTitle
        note.value = getNote.note
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail Page") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple),
                    titleContentColor = Color.White
                )
            )

        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    value = noteTitle.value,
                    onValueChange = { noteTitle.value = it },
                    label = { Text("Note Title") },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, top = 40.dp)
                )

                OutlinedTextField(
                    value = note.value,
                    onValueChange = { note.value = it },
                    label = { Text("Note Field") },
                    textStyle = MaterialTheme.typography.titleLarge,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 8.dp)
                )
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    noteTitle.value
                    note.value

                    viewModel.updateNotes(getNote.noteId,noteTitle.value,note.value)
                    Log.e("Note Update","${getNote.noteId}  $noteTitle - $note")
                },
                containerColor = colorResource(id = R.color.purple),
                contentColor = Color.White

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_published_with_changes_24),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}