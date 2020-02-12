package ca.russell_waterhouse.hackthecode.model

import android.content.Context
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DefaultModelTest {

    private lateinit var mockRepository: Repository
    private lateinit var mockEncoderFactory: EncoderFactory
    private lateinit var model: Model
    private lateinit var context: Context

    @Before
    fun setUp() {
        mockRepository = Mockito.mock(Repository::class.java)
        mockEncoderFactory = Mockito.mock(EncoderFactory::class.java)
        model = DefaultModel(mockRepository, mockEncoderFactory)

    }


    @Test
    fun testInit(){
        Mockito.verify(mockEncoderFactory).getEncoder(1)
    }


    @Test
    fun encodeWord() {
        TODO("Not implemented")
    }

    @Test
    fun setLevel() {
        val level = 5
        model.setLevel(level)
        Mockito.verify(mockEncoderFactory).getEncoder(level)
        assertEquals(level, model.getLevel())
    }

    @Test
    fun getLevel() {
        val model = DefaultModel(mockRepository, mockEncoderFactory)
        assertEquals(1, model.getLevel())
    }

    @Test
    fun getLiveDataWords() {
        TODO("Not implemented")
    }

    @Test
    fun testString() {
        TODO("Not implemented")
    }

    @Test
    fun getHint() {
        TODO("Not implemented")
    }

    @Test
    fun getLevelWord() {
        TODO("Not implemented")
    }

    @Test
    fun deleteAllFromDatabase() {
        TODO("Not implemented")
    }
}