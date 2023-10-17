package com.example.movies.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.movies.MainViewModel

@Composable
fun DetailsScreens(navController: NavHostController, viewModel: MainViewModel, itemId: String) {
    Text(text = "Details id: $itemId")
}