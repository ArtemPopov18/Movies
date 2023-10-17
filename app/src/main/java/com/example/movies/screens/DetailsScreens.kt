package com.example.movies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.movies.MainViewModel
import com.example.movies.utils.HtmlText

@Composable
fun DetailsScreens(viewModel: MainViewModel, itemId: String) {
    val currentItem = viewModel.allMovies.observeAsState(listOf()).value.firstOrNull {
        it.id == itemId.toInt()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {
        LazyColumn {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberAsyncImagePainter(currentItem?.image?.medium),
                        contentDescription = null,
                        modifier = Modifier.size(512.dp)
                    )
                    Text(
                        text = currentItem?.name ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Row {
                        Text(
                            text = "Rating: ${currentItem?.rating?.average}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row {
                        Text(
                            text = "Genre: ",
                            fontWeight = FontWeight.Bold
                        )
                        currentItem?.genres?.take(2)?.forEach { Text(text = " $it") }
                    }
                    HtmlText(
                        html = currentItem?.summary ?: "",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }
        }
    }
}