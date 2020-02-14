package ca.russell_waterhouse.hackthecode.test_dependency_injection

import dagger.Module

@Module(subcomponents = [
    TestSettingsComponent::class,
    TestLevelComponent::class
])
class TestSubComponentsModule