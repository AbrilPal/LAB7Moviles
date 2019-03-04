package com.example.abril.lab7moviles

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.abril.lab7moviles.Data.ContactoDataBase
import com.example.abril.lab7moviles.Data.Repositorio
import com.example.abril.lab7moviles.MainActivity
import com.example.abril.lab7moviles.R


class ContactViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_view)

        val contactos = (this.application as Repositorio)

        val currentName = findViewById<TextView>(R.id.nameText)
        val currentNum = findViewById<TextView>(R.id.phoneText)
        val currentMail = findViewById<TextView>(R.id.mailText)

        val botonEditar = findViewById<Button>(R.id.editButton)
        botonEditar.setOnClickListener {
            val intent = Intent(this, EditContactActivity::class.java)
            startActivity(intent)
        }

    }
}

