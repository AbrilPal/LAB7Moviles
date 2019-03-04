package com.example.abril.lab7moviles

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.abril.lab7moviles.Data.ContactoDataBase
import com.example.abril.lab7moviles.Data.ContactosImp
import com.example.abril.lab7moviles.Data.Repositorio
import com.example.abril.lab7moviles.MainActivity
import com.example.abril.lab7moviles.R

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        val contactos = (this.application as Repositorio)

        val botonReturn = findViewById<Button>(R.id.buttonReturn)
        botonReturn.setOnClickListener { val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        val idI = findViewById<EditText>(R.id.idInput)
        val name = findViewById<EditText>(R.id.nameInput)
        val tel = findViewById<EditText>(R.id.numInput)
        val mail = findViewById<EditText>(R.id.mailInput)

        val agregar = findViewById<Button>(R.id.buttonCreate)
    }
}
