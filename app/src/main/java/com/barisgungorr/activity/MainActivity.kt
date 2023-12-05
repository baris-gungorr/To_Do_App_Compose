package com.barisgungorr.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.barisgungorr.entity.Notes
import com.barisgungorr.todoappcompose.R
import com.barisgungorr.todoappcompose.notesaddscreen.AddNotesScreen
import com.barisgungorr.todoappcompose.ui.theme.ToDoAppComposeTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppComposeTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val searchCurrent = remember { mutableStateOf(false) }
    val searchValue = remember { mutableStateOf("") }
    val noteList = remember { mutableStateListOf<Notes>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    if (searchCurrent.value) {
                        TextField(
                            value = searchValue.value,
                            onValueChange = {
                                searchValue.value = it
                                Log.e("searchValue", it)
                            },

                            label = { Text(text = "Search", color = Color.White) },

                            colors = TextFieldDefaults.textFieldColors(
                                focusedTextColor = Color.White,
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.White,
                                cursorColor = Color.White,

                                )
                        )
                    } else {
                        Text(text = "Archive")

                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple),
                    titleContentColor = Color.White,
                ),
                actions = {
                    if (searchCurrent.value) {
                        IconButton(onClick = {
                            searchCurrent.value = false
                            searchValue.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_close_24),
                                contentDescription = "", tint = Color.White
                            )

                        }
                    } else {
                        IconButton(onClick = {
                            searchCurrent.value = true
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_search_24),
                                contentDescription = "", tint = Color.White
                            )

                        }
                    }
                }
            )
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
                    painter = painterResource(id = R.drawable.baseline_post_add_24),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}


