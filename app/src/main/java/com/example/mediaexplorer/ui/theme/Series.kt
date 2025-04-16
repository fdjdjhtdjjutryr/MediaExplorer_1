package com.example.mediaexplorer.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mediaexplorer.PantallaPeliculas

class Series : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

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