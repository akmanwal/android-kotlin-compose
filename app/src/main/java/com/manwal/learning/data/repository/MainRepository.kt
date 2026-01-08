package com.manwal.learning.data.repository

import com.manwal.learning.data.api.ApiService
import com.manwal.learning.data.model.Post
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}