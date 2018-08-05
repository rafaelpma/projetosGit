package com.example.rafaelpaz.persistenciadados

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Personagem (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val mundoOrigem: String

)