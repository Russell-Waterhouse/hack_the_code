package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.dependency_injection.SettingsComponent
import ca.russell_waterhouse.hackthecode.ui.settings.SettingsActivity
import dagger.Subcomponent

@Subcomponent(modules = [MockModelModule::class])
interface TestSettingsComponent: SettingsComponent{

    @Subcomponent.Factory
    interface Factory: SettingsComponent.Factory{
        override fun create(): TestSettingsComponent
    }

    override fun inject(settings: SettingsActivity)
}