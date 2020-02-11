package ca.russell_waterhouse.hackthecode

import android.app.Application
import ca.russell_waterhouse.hackthecode.dependency_injection.AppModule
import ca.russell_waterhouse.hackthecode.dependency_injection.ContextModule
import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity
import ca.russell_waterhouse.hackthecode.ui.level.LevelFragment
import ca.russell_waterhouse.hackthecode.ui.settings.SettingsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ContextModule::class
])

interface ApplicationComponent{
    fun inject(level: LevelActivity)
    fun inject(settings: SettingsActivity)
    fun inject(fragment: LevelFragment)

    @Component.Builder
    interface Builder{
        fun contextModule(contextModule: ContextModule): Builder
        fun build(): ApplicationComponent
    }
}

class HackTheCodeApplication: Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.builder().contextModule(ContextModule(this)).build()
}