package com.manwal.learning.data.api

import com.manwal.learning.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}