package ca.russell_waterhouse.hackthecode.dependency_injection

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ContextModule (val context: Context){

    @Provides
    fun provideContext(): Context {
        return context
    }
}