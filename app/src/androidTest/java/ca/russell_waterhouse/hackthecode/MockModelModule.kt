package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.model.DefaultModel
import ca.russell_waterhouse.hackthecode.model.Model
import dagger.Module
import dagger.Provides
import org.mockito.Mockito

@Module
class MockModelModule {

    @Provides
    fun provideModel(): Model{
        return Mockito.mock(DefaultModel::class.java)
    }
}