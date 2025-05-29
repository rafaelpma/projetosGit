package com.example.rafaelpaz.persistenciadados.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.rafaelpaz.persistenciadados.Personagem


@Dao
interface PersonagemDao {

    @Query("SELECT * FROM Personagem")
    fun all() : List<Personagem>

    @Insert
    fun add(vararg personagem: Personagem)
}