package com.example.mediaexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.mediaexplorer.ui.theme.MediaExplorerTheme
import androidx.compose.runtime.Composable

class Peliculas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPeliculas()
        }
    }
}

@Composable
fun ListaPeliculas() {
    val peliculas = remember { mutableStateListOf("Inception", "Matrix", "Interstellar") }
    var nuevaPelicula by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Películas", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = nuevaPelicula,
            onValueChange = { nuevaPelicula = it },
            label = { Text("Añadir nueva película") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (nuevaPelicula.isNotBlank()) {
                    peliculas.add(nuevaPelicula)
                    nuevaPelicula = ""
                }
            }

        ) {
            Text("Añadir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(peliculas) { pelicula ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = pelicula)
                        IconButton(onClick = { peliculas.remove(pelicula) }) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaPeliculas() {
    ListaPeliculas()
}

@Preview(showBackground = true)
@Composable
fun ListaPeliculasPreview() {
    MediaExplorerTheme {
        ListaPeliculas()
    }
}