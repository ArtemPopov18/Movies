package com.example.movies.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movies.MainViewModel
import com.example.movies.data.models.Movies

@Composable
fun MainScreens(navController: NavHostController, viewModel: MainViewModel) {
    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn{
            items(allMovies.take(10)){item ->
                MoviesItem(item = item)
            }
        }
    }
}

@Composable
fun MoviesItem(item: Movies) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = item.id.toString())
        Text(text = item.name)
    }
}