package com.example.abril.lab7moviles.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
class ContactosImp (var nombre: String,var tel:String, var mail :String, var idp: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}