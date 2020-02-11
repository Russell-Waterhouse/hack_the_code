package ca.russell_waterhouse.hackthecode.dependency_injection

import ca.russell_waterhouse.hackthecode.ui.level.LevelActivity
import ca.russell_waterhouse.hackthecode.ui.level.LevelFragment
import dagger.Subcomponent
import javax.inject.Scope


@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@ActivityScope
@Subcomponent
interface LevelComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): LevelComponent
    }

    fun inject(level: LevelActivity)
    fun inject(levelFragment: LevelFragment)
}