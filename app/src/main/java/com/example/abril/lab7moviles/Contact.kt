package com.example.abril.lab7moviles

import android.os.AsyncTask
import com.example.abril.lab7moviles.Data.ContactoDataBase
import com.example.abril.lab7moviles.Data.ContactosImp

class Contact{

    constructor(id: Int,nombre: String, telefono: String, correo: String){
        this.id = id
        this.nombre = nombre
        this.telefono = telefono
        this.correo = correo
    }

    var id: Int = 0
    var nombre:String = ""
    var telefono: String = ""
    var correo:String = ""

    override fun toString(): String {
        return """
            ${this.nombre} - ${this.telefono}
        """.trimIndent()
    }
}