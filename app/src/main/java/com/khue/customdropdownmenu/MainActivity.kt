package com.khue.customdropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import com.khue.customdropdownmenu.ui.theme.CustomDropdownMenuTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomDropdownMenuTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize() ,
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Helloooooooo") },
                            actions = {
                                var isExpanded by remember { mutableStateOf(false) }

                                Box {
                                    IconButton(onClick = { isExpanded = true }) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                                    }

                                    CustomDropdownMenu(
                                        expanded = isExpanded,
                                        onDismissRequest = { isExpanded = false }
                                    ) {
                                        repeat(5) {
                                            DropdownMenuItem(
                                                text = {
                                                    Text(text = "Item 1")
                                                },
                                                onClick = { }
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar {
                            repeat(15) {
                                var isExpanded by remember { mutableStateOf(false) }

                                Box(
                                ) {
                                    IconButton(onClick = { isExpanded = true }) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                                    }

                                    CustomDropdownMenu(
                                        expanded = isExpanded,
                                        onDismissRequest = { isExpanded = false }
                                    ) {
                                        repeat(5) {
                                            DropdownMenuItem(
                                                text = {
                                                    Text(text = "Item 1")
                                                },
                                                onClick = { }
                                            )
                                        }
                                    }
                                }
                            }

                        }
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        items(50) {
                            Greeting()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.TopEnd
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isExpanded = true }
        ) {
            Text(text = "Dropdown")
        }

        CustomDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            DropdownMenuItem(
                text = {
                       Text(text = "Item 1")
                },
                onClick = { }
            )
        }
    }
}
