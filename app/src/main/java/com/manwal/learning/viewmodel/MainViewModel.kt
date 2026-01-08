package com.manwal.learning.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manwal.learning.entity.PostDao
import com.manwal.learning.entity.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

// 1. Define the UI State
sealed class MainUiState {
    object Loading : MainUiState()
    data class Success(val posts: List<PostEntity>) : MainUiState()
    data class Error(val message: String) : MainUiState()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    postDao: PostDao // Hilt injects this from your DatabaseModule
) : ViewModel() {

    // 2. Observe the database Flow
    val uiState: StateFlow<MainUiState> = postDao.getAllPosts()
        .map { posts ->
            if (posts.isEmpty()) {
                // If empty, it might be seeding, or actually empty.
                // Since your callback seeds immediately, this usually flips to Success quickly.
                MainUiState.Loading
            } else {
                MainUiState.Success(posts)
            }
        }
        .catch { e ->
            emit(MainUiState.Error(e.message ?: "Unknown error"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = MainUiState.Loading
        )
}
