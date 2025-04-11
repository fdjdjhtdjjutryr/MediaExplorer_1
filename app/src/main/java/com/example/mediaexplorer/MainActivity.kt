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
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediaExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
    val expanded = remember { mutableStateOf(true) }
    val extraPadding = if(expanded.value)60.dp else 0.dp

    Column(modifier = Modifier.padding(bottom = extraPadding)) {
        Text(text="")
        Text(text="MediaExplorer")
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {

            Image(painter = painterResource(id=R.drawable.claqueta), contentDescription = "Peliculas"
            ,modifier = Modifier.padding(8.dp).size(48.dp))
            Text(if(expanded.value) "Peliculas" else "MMMMM")
        }
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
            Image(painter = painterResource(id=R.drawable.series), contentDescription = "Peliculas",
                modifier = Modifier.padding(8.dp).size(48.dp))
            Text(if(expanded.value) "Series" else "MMMMM")
        }
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
            Image(painter = painterResource(id=R.drawable.anime), contentDescription = "Peliculas",
                modifier = Modifier.padding(8.dp).size(48.dp))
            Text(if(expanded.value) "Anime" else "MMMMM")
        }
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
            Image(painter = painterResource(id=R.drawable.mas), contentDescription = "Peliculas",
                modifier = Modifier.padding(8.dp).size(48.dp))
            Text(if(expanded.value) "Anadir Categoria" else "MMMMM")
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