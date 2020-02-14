package ca.russell_waterhouse.hackthecode.dependency_injection

import ca.russell_waterhouse.hackthecode.ui.settings.SettingsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ModelBindsModule::class])
interface SettingsComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create(): SettingsComponent
    }

    fun inject(settings: SettingsActivity)
}