package ca.russell_waterhouse.hackthecode

import android.content.Context
import ca.russell_waterhouse.hackthecode.dependency_injection.ContextModule
import ca.russell_waterhouse.hackthecode.dependency_injection.SettingsComponent
import ca.russell_waterhouse.hackthecode.dependency_injection.WordDaoModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WordDaoModule::class,
    ContextModule::class,
    TestSubComponentsModule::class
])
interface TestApplicationComponent: ApplicationComponent {

    override fun settingsComponent(): TestSettingsComponent.Factory
    @Component.Builder
    interface Builder{
        fun contextModule(contextModule: ContextModule): Builder
        fun build(): TestApplicationComponent
    }
}