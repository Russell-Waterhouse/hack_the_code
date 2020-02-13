package ca.russell_waterhouse.hackthecode.dependency_injection

import android.content.Context
import ca.russell_waterhouse.hackthecode.database.WordDAO
import ca.russell_waterhouse.hackthecode.database.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object WordDaoModule{

    @JvmStatic
    @Provides
    @Singleton
    fun provideDAO(
        context: Context
    ):WordDAO{
        return WordDatabase.getDatabaseInstance(context).wordDAO()
    }
}