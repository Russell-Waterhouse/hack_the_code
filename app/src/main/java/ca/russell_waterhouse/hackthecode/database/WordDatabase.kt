package ca.russell_waterhouse.hackthecode.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase(){
    abstract fun wordDAO(): WordDAO

    companion object{
        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getDatabaseInstance(context: Context): WordDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context, WordDatabase::class.java, "word_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}