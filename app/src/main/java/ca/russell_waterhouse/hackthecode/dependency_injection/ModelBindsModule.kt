package ca.russell_waterhouse.hackthecode.dependency_injection

import ca.russell_waterhouse.hackthecode.model.DefaultModel
import ca.russell_waterhouse.hackthecode.model.Model
import dagger.Binds
import dagger.Module

@Module
abstract class ModelBindsModule {

    @ActivityScope
    @Binds
    abstract fun bindModel(model: DefaultModel): Model
}