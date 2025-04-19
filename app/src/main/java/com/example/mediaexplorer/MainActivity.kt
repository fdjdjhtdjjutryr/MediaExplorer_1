package com.example.mediaexplorer

import android.content.Intent
import android.content.Context
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
import androidx.compose.runtime.mutableStateListOf
import com.example.mediaexplorer.ui.theme.Series

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediaExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    uno(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        context = this
                    )
                }
            }
        }
    }
}


@Composable
fun uno(name: String, modifier: Modifier = Modifier, context : Context) {
    val expanded = remember { mutableStateOf(true) }
    val extraPadding = if(expanded.value) 60.dp else 0.dp
    val categorias = remember {
        mutableStateOf(
            mutableListOf(
                Categoria("Películas", R.drawable.claqueta) {
                    context.startActivity(Intent(context, Peliculas::class.java))
                },
                Categoria("Series", R.drawable.series) {
                    context.startActivity(Intent(context, Series::class.java))
                },
                Categoria("Anime", R.drawable.anime) {
                    expanded.value = !expanded.value
                }

            )
        )
    }

    Column(modifier = Modifier.padding(bottom = extraPadding)) {
        Text(text = "MediaExplorer")


        categorias.value.forEach { categoria ->
            ElevatedButton(onClick = categoria.onClick) {
                Image(
                    painter = painterResource(id = categoria.icon),
                    contentDescription = categoria.nombre,
                    modifier = Modifier.padding(8.dp).size(48.dp)
                )
                Text(if (expanded.value) categoria.nombre else "MMMMM")
            }
        }

        ElevatedButton(onClick = {
            categorias.value.add(
                Categoria("Nueva Categoria", R.drawable.mas) {
                }
            )
        }) {
            Image(
                painter = painterResource(id = R.drawable.mas),
                contentDescription = "Añadir",
                modifier = Modifier.padding(8.dp).size(48.dp)
            )
            Text("Añadir Categoria")
        }

    }
}


data class Categoria(
    val nombre: String,
    val icon: Int,
    val onClick: () -> Unit
)

@Composable
fun unoPreview(modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(true) }
    val extraPadding = if (expanded.value) 60.dp else 0.dp

    Column(modifier = Modifier.padding(bottom = extraPadding)) {
        Text(text = "")
        Text(text = "MediaExplorer")
        ElevatedButton(onClick = {}) {
            Text(if (expanded.value) "Peliculas" else "MMMMM")
        }
        ElevatedButton(onClick = {}) {
            Text(if (expanded.value) "Series" else "MMMMM")
        }
        ElevatedButton(onClick = {}) {
            Text(if (expanded.value) "Anime" else "MMMMM")
        }
        ElevatedButton(onClick = {}) {
            Text(if (expanded.value) "Añadir Categoria" else "MMMMM")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MediaExplorerTheme {
        unoPreview()
    }
}

