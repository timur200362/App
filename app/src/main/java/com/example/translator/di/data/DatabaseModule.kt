package com.example.translator.di.data

import android.content.Context
import androidx.room.Room
import com.example.translator.data.database.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providesWordDatabase(context: Context): WordDatabase {
        return Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            "word_database"
        ).build()
    }
}