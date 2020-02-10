package ca.russell_waterhouse.hackthecode.dependency_injection

import android.content.Context
import ca.russell_waterhouse.hackthecode.database.WordDAO
import ca.russell_waterhouse.hackthecode.database.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule{

    @JvmStatic
    @Provides
    @Singleton
    fun provideDAO(
        database: WordDatabase
    ):WordDAO{
        return database.wordDAO()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideDatabase(context: Context): WordDatabase{
        return WordDatabase.getDatabaseInstance(context)
    }
}