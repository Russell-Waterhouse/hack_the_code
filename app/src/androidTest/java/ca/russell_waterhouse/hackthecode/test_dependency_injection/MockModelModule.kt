package ca.russell_waterhouse.hackthecode.test_dependency_injection

import androidx.lifecycle.MutableLiveData
import ca.russell_waterhouse.hackthecode.database.WordEntity
import ca.russell_waterhouse.hackthecode.model.DefaultModel
import ca.russell_waterhouse.hackthecode.model.Model
import dagger.Module
import dagger.Provides
import org.mockito.Mockito

@Module
class MockModelModule {

    @Provides
    fun provideModel(): Model{
        val mockModel = Mockito.mock(DefaultModel::class.java)
//         this is done to test display on level.
//        see LevelActivityTest.kt for more information
        val entity = WordEntity(1, "test string", "ENCODED TEST STRING")
        val entities = arrayListOf<WordEntity>()
        entities.add(entity)
        val liveData = MutableLiveData<List<WordEntity>>()
        liveData.postValue(entities)
        Mockito.`when`(mockModel.getLiveDataWords()).thenReturn(liveData)
        return mockModel
    }
}