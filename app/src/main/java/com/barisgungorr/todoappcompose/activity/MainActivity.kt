package com.barisgungorr.todoappcompose.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.barisgungorr.todoappcompose.data.Notes
import com.barisgungorr.todoappcompose.R
import com.barisgungorr.todoappcompose.screen.notesaddscreen.AddNotesScreen
import com.barisgungorr.todoappcompose.screen.notesdetailscreen.NoteDetailScreen
import com.barisgungorr.todoappcompose.ui.theme.ToDoAppComposeTheme
import com.barisgungorr.todoappcompose.viewmodel.HomeScreenViewModel
import com.google.gson.Gson

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
                    PageTransition()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppComposeTheme {

    }
}

@Composable
fun PageTransition() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homePage" ) {
        composable("homePage") {
            HomeScreen(navController = navController)
        }
        composable("addNotesScreen") {
            AddNotesScreen()
        }
        composable("noteDetailScreen/{note}", arguments = listOf(
            navArgument("note") {type = NavType.StringType}
        )) {
            val json = it.arguments?.getString("note")
            val objects = Gson().fromJson(json, Notes::class.java)
            NoteDetailScreen(objects)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    val searchCurrent = remember { mutableStateOf(false) }
    val searchValue = remember { mutableStateOf("") }

    val viewModel: HomeScreenViewModel = viewModel()
    val noteList = viewModel.notesList.observeAsState(listOf())




    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    if (searchCurrent.value) {
                        TextField(
                            value = searchValue.value,
                            onValueChange = {
                                searchValue.value = it
                                viewModel.searchNotes(searchValue.value)
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
                  LazyColumn(
                      contentPadding = PaddingValues(top = 60.dp),
                  ) {
                      items(
                          count = noteList.value!!.count(),
                          itemContent = {
                              val note = noteList.value!![it]

                              Card(modifier = Modifier
                                  .padding(top = 10.dp)
                                  .fillMaxWidth()) {

                                  Row(
                                      modifier = Modifier
                                          .fillMaxWidth()
                                          .clickable {
                                              val notesJson = Gson().toJson(note)
                                              navController.navigate("noteDetailScreen/${notesJson}")

                                          }) {
                                      Row(
                                          modifier = Modifier
                                              .padding(top = 10.dp)
                                              .fillMaxWidth(),
                                          verticalAlignment = Alignment.CenterVertically,
                                          horizontalArrangement = Arrangement.SpaceBetween
                                      ) {
                                          Text(text = "${note.noteTitle} - ${note.note}")

                                         IconButton(onClick = {
                                                viewModel.deleteNotes(note.noteId)
                                         }) {
                                             Icon(painter = painterResource(id = R.drawable.baseline_delete_outline_24),
                                                 contentDescription = "", tint = Color.Gray )

                                         }
                                      }
                                  }
                              }
                          }
                      )
                    }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addNotesScreen")},
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


