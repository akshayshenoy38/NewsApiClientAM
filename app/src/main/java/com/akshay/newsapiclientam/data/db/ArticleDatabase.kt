package com.akshay.newsapiclientam.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.akshay.newsapiclientam.data.model.Article

@Database(entities = [Article::class],
version = 1,
exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun getArticleDao():ArticleDao
}