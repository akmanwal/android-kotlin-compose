package com.manwal.learning.entity

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        provider: Provider<PostDao> // Inject Provider to avoid circular dependency in Callback
    ): AppDatabase {
        return Room.databaseBuilder( // This starts the builder for the Room database named "learning_database".
            context,
            AppDatabase::class.java,
            "learning_database"
        )
            .addCallback(object : RoomDatabase.Callback() { // This attaches a listener to the database creation lifecycle. This is crucial for your "seed data" requirement.
                // This runs only when the database is created for the first time
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        val dao = provider.get()
                        val dummyList = List(50) { i ->
                            PostEntity(
                                title = "Local Post #${i + 1}",
                                body = "This is the body for entry number ${i + 1} stored in Room."
                            )
                        }
                        dao.insertAll(dummyList)
                    }
                }
            })
            .build() // he database instance is created (but not yet opened).
    }

    @Provides
    fun providePostDao(database: AppDatabase): PostDao {
        return database.postDao()
    }
}
