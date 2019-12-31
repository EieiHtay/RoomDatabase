package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.roomdatabase.database.AppDatabase
import com.example.roomdatabase.entity.BookEntity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"BookDB").build()

        //Insert case
        Thread{
            var bookEntity=BookEntity()
            bookEntity.bookId=1
            bookEntity.bookName="Kotlin for Android Developer"
            db.bookDao().saveBooks(bookEntity)

            //fetch Records
            db.bookDao().getAllBooks().forEach(){
                Log.i("Fetch Records","Id:${it.bookId}")
                Log.i("Fetch Records","Id:${it.bookName}")
            }
        }.start()
    }
}
