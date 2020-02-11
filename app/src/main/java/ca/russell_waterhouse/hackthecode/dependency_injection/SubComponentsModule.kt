package ca.russell_waterhouse.hackthecode.dependency_injection

import dagger.Module


@Module(subcomponents = [
    LevelComponent::class,
    SettingsComponent::class
])
class SubComponentsModule