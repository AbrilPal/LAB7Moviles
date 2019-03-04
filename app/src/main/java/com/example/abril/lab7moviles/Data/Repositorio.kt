package com.example.abril.lab7moviles.Data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class Repositorio (application: Application) {
    private var contactDao:Contactos

    private var allContacts: LiveData<List<ContactosImp>>

    init {
        val database: ContactoDataBase = ContactoDataBase.getInstance(
            application.applicationContext
        )!!
        contactDao = database.contactDao()
        allContacts = contactDao.getAllContacts()
    }

    fun insert(contact: ContactosImp) {
        val insertContactAsyncTask = InsertContactAsyncTask(contactDao).execute(contact)
    }

    fun update(contact: ContactosImp) {
        val updateContactAsyncTask = UpdateContactAsyncTask(contactDao).execute(contact)
    }

    fun delete(contact: ContactosImp) {
        val deleteNoteAsyncTask = DeleteContactAsyncTask(contactDao).execute(contact)
    }

    fun deleteAllNotes() {
        val deleteAllNotesAsyncTask = DeleteAllContactAsyncTask(
            contactDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<ContactosImp>> {
        return allContacts
    }

    companion object {
        private class InsertContactAsyncTask(contactDao: Contactos) : AsyncTask<ContactosImp, Unit, Unit>() {
            val contactDao = contactDao

            override fun doInBackground(vararg params: ContactosImp?) {
                contactDao.insert(params[0]!!)
            }
        }

        private class UpdateContactAsyncTask(contactDao: Contactos) : AsyncTask<ContactosImp, Unit, Unit>() {
            val contactDao = contactDao

            override fun doInBackground(vararg params: ContactosImp?) {
                contactDao.update(params[0]!!)
            }
        }

        private class DeleteContactAsyncTask(contactDao: Contactos) : AsyncTask<ContactosImp, Unit, Unit>() {
            val contactDao = contactDao

            override fun doInBackground(vararg params: ContactosImp?) {
                contactDao.delete(params[0]!!)
            }
        }

        private class DeleteAllContactAsyncTask(contactDao: Contactos) : AsyncTask<Unit, Unit, Unit>() {
            val contactDao = contactDao

            override fun doInBackground(vararg params: Unit?) {
                contactDao.deleteAllContacts()
            }
        }
    }
}