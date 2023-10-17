package com.example.movies.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val appService: AppService) {

    suspend fun getAllMovies() = appService.getAllMovies()
}