package ca.russell_waterhouse.hackthecode.test_dependency_injection

import ca.russell_waterhouse.hackthecode.dependency_injection.LevelComponent
import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity
import ca.russell_waterhouse.hackthecode.ui.level.LevelFragment
import dagger.Subcomponent

@Subcomponent(modules = [MockModelModule::class])
interface TestLevelComponent: LevelComponent {
    override fun inject(level: LevelActivity)
    override fun inject(levelFragment: LevelFragment)

    @Subcomponent.Factory
    interface Factory: LevelComponent.Factory{
        override fun create(): TestLevelComponent
    }
}