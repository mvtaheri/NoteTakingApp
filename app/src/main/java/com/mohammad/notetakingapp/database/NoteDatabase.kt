package com.mohammad.notetakingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohammad.notetakingapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao

    companion object{
        @Volatile
        private var instanse:NoteDatabase?=null
        private val LOCK=Any()

        operator fun invoke(contex:Context)= instanse?:
          synchronized(LOCK){
              instanse?:
              createDatabase(contex).also{
                  instanse=it
              }
          }

        private fun createDatabase(contex: Context)=Room.databaseBuilder(
            contex.applicationContext,
            NoteDatabase::class.java,
            "note_db"
        ).build()
    }

}