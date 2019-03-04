package com.example.abril.lab7moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.abril.lab7moviles.Data.ContactoDataBase
import com.example.abril.lab7moviles.Data.Repositorio
import com.example.abril.lab7moviles.R

class EditContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        val contactos = (this.application as Repositorio)

    }
}
