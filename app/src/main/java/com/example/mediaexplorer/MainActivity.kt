package com.example.mediaexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mediaexplorer.ui.theme.MediaExplorerTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediaExplorerTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    uno(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun uno(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    Column(modifier=modifier.padding(24.dp)){
        ElevatedButton(
            onClick={expanded.value= !expanded.value}) {

        }
        ElevatedButton(
            onClick={expanded.value= !expanded.value}) {
            Text(text="Series")
        }
        ElevatedButton(
            onClick={expanded.value= !expanded.value}) {
            Text(text="Anime")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MediaExplorerTheme {
        uno("?")
    }
}
