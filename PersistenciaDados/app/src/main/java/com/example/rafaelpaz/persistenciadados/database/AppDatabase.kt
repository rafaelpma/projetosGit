package com.example.rafaelpaz.persistenciadados.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.rafaelpaz.persistenciadados.Personagem
import com.example.rafaelpaz.persistenciadados.database.dao.PersonagemDao

@Database(entities = [Personagem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personagemDao(): PersonagemDao

}