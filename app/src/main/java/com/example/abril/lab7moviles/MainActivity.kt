package com.example.abril.lab7moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast


import com.example.abril.lab7moviles.ContactViewActivity
import com.example.abril.lab7moviles.Data.ContactoDataBase
import com.example.abril.lab7moviles.Data.Repositorio

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonNewContact = findViewById<Button>(R.id.buttonNewContact)
        botonNewContact.setOnClickListener{val intent = Intent(this, NewContactActivity::class.java)
            startActivity(intent)}

        val contactos = (this.application as Repositorio)

    }
}