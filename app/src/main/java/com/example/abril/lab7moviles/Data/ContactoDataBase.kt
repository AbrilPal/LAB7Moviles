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
                        ContactoDataBase::class.java,"DBP"
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
        private val contact = db?.contactDao()

        override fun doInBackground(vararg p0: Unit?) {
            contact?.insert(ContactosImp("Abril","45789215","pal18198@uvg.edu.gt",1))
            contact?.insert(ContactosImp("Andy","78501248","AndyPandy@gmail.com",2))
            contact?.insert(ContactosImp("Alex","85624789","AlexP@gmail.com",3))
        }
    }

}