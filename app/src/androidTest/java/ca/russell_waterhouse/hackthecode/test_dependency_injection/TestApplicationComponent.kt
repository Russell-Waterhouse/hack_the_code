package ca.russell_waterhouse.hackthecode.test_dependency_injection

import ca.russell_waterhouse.hackthecode.ApplicationComponent
import ca.russell_waterhouse.hackthecode.dependency_injection.ContextModule
import ca.russell_waterhouse.hackthecode.dependency_injection.WordDaoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WordDaoModule::class,
    ContextModule::class,
    TestSubComponentsModule::class
])
interface TestApplicationComponent:
    ApplicationComponent {

    override fun settingsComponent(): TestSettingsComponent.Factory
    override fun levelComponent(): TestLevelComponent.Factory

    @Component.Builder
    interface Builder{
        fun contextModule(contextModule: ContextModule): Builder
        fun build(): TestApplicationComponent
    }
}