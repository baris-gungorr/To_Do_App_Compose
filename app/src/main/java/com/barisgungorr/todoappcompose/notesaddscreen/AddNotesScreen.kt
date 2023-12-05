package com.barisgungorr.todoappcompose.notesaddscreen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.barisgungorr.todoappcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNotesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registration Page") })
        },
        content = {

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = colorResource(id = R.color.purple),
                contentColor = Color.White

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bookmark_24),
                    contentDescription = "",
                    tint = Color.White
                )

            }
        }
    )
}