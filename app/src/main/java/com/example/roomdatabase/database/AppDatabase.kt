package com.example.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.dao.BookDAO
import com.example.roomdatabase.entity.BookEntity

@Database(entities = [(BookEntity::class)],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun bookDao():BookDAO
}