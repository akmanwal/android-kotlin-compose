package com.manwal.learning.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    // Helper to get all posts as a reactive Flow
    @Query("SELECT * FROM posts")
    fun getAllPosts(): Flow<List<PostEntity>>

    // Insert a list of posts (used for your 50 entries requirement)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<PostEntity>)

    // Helper to check if the database is empty
    @Query("SELECT COUNT(*) FROM posts")
    fun getCount(): Int
}