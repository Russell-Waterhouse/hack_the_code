package ca.russell_waterhouse.hackthecode

import android.app.Application
import ca.russell_waterhouse.hackthecode.dependency_injection.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WordDaoModule::class,
    ContextModule::class,
    SubComponentsModule::class
])
interface ApplicationComponent{

    fun levelComponent():LevelComponent.Factory
    fun settingsComponent(): SettingsComponent.Factory

    @Component.Builder
    interface Builder{
        fun contextModule(contextModule: ContextModule): Builder
        fun build(): ApplicationComponent
    }
}

open class HackTheCodeApplication: Application() {
    open val appComponent: ApplicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
}