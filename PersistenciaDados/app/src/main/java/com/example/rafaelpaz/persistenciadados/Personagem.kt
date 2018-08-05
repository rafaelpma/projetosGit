package com.example.rafaelpaz.persistenciadados

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
class Personagem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val altura: String,
    val peso: String,
    val corDeCabelo: String,
    val anoAniversario: String

) : Serializable