package com.example.abril.lab7moviles.Data


import androidx.lifecycle.LiveData
import androidx.room.*



@Dao
interface Contactos {

        @Insert
        fun insert(contact: ContactosImp)

        @Update
        fun update(contact: ContactosImp)

        @Delete
        fun delete(contact: ContactosImp)

        @Query("DELETE FROM contact_table")
        fun deleteAllContacts()

        @Query("SELECT * FROM contact_table ORDER BY priority DESC")
        fun getAllContacts(): LiveData<List<ContactosImp>>
    }