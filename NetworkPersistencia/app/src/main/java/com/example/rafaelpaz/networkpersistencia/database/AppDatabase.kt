package com.example.rafaelpaz.persistenciadados.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.rafaelpaz.networkpersistencia.Personagem
import com.example.rafaelpaz.networkpersistencia.database.dao.PersonagemDao


@Database(entities = [Personagem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personagemDao(): PersonagemDao

}