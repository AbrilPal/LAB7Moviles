package com.example.abril.lab7moviles.Data
import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contactos::class],version = 1)
abstract class ContactoDataBase: RoomDatabase() {

    abstract fun contactDao(): Contactos

    companion object {
        private var instance: ContactoDataBase? = null

        fun getInstance(context: Context):ContactoDataBase? {
            if (instance == null) {
                synchronized(ContactoDataBase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactoDataBase::class.java,"contact_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }

    class PopulateDbAsyncTask(db: ContactoDataBase?) : AsyncTask<Unit, Unit, Unit>(){
        private val contactDao = db?.contactDao()

        override fun doInBackground(vararg p0: Unit?) {
            contactDao?.insert(ContactosImp("Pepito","5123467","pepito@gmail.com",1))
            contactDao?.insert(ContactosImp("Pepita","7643215","pepita@gmail.com",2))
            contactDao?.insert(ContactosImp("Juanito","555555","juanitoelbonito@gmail.com",3))
        }
    }

}