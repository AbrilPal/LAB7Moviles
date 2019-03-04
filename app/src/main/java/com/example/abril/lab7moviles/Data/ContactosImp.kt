package com.example.abril.lab7moviles.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
class ContactosImp (var name: String,var phone:String, var mail :String, var priority: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}