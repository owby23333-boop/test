package com.reader

import android.app.Application
import com.reader.database.AppDatabase
import android.content.Context

class ReaderApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getDatabase(this)
    }

    companion object {
        lateinit var instance: ReaderApp
            private set

        lateinit var database: AppDatabase
            private set

        fun getReadingProgressDao(): com.reader.data.dao.ReadingProgressDao =
            database.readingProgressDao()
    }
}