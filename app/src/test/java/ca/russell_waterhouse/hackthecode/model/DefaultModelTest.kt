package ca.russell_waterhouse.hackthecode.model

import android.content.Context
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderFactory
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderStateLevel1
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DefaultModelTest{

    private lateinit var mockRepository: Repository
    private lateinit var mockEncoderFactory: EncoderFactory
    private lateinit var mockEncoder: EncoderStateLevel1
    private lateinit var model: Model
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        mockRepository = mock(Repository::class.java)
        mockEncoder = mock(EncoderStateLevel1::class.java)
        mockEncoderFactory = mock(EncoderFactory::class.java)
        Mockito.`when`(mockEncoderFactory.getEncoder(1)).thenReturn(mockEncoder)
        model = DefaultModel(mockRepository, mockEncoderFactory)
        mockContext = mock(Context::class.java)
    }


    @Test
    fun testInit(){
        verify(mockEncoderFactory).getEncoder(1)
    }


    @Test
    fun encodeWord() {
        val testWord = "Test word"
        val testResult = "Resulting string"
        Mockito.`when`(mockEncoder.encode(testWord)).thenReturn(testResult)
        runBlocking {
            model.encodeWord(testWord)
            verify(mockEncoder).encode(testWord)
            verify(mockRepository).insertWord(Entity(1, testWord, testResult))
        }
    }

    @Test
    fun setLevel() {
        val level = 5
        model.setLevel(level)
        verify(mockEncoderFactory).getEncoder(level)
        assertEquals(level, model.getLevel())
    }

    @Test
    fun getLevel() {
        val model = DefaultModel(mockRepository, mockEncoderFactory)
        assertEquals(1, model.getLevel())
    }

    @Test
    fun getLiveDataWords() {
        model.getLiveDataWords()
        verify(mockRepository).getWordsForLevel(1)
    }

    @Test
    fun testString() {
        val testWord = "test word"
        model.testString(mockContext, testWord)
        verify(mockEncoder).testString(mockContext, testWord)
    }

    @Test
    fun getHint() {
        model.getHint(mockContext)
        verify(mockEncoder).getHint(mockContext)
    }

    @Test
    fun getLevelWord() {
        model.getLevelWord(mockContext)
        verify(mockEncoder).getLevelWord(mockContext)
    }

    @Test
    fun deleteAllFromDatabase() {
        runBlocking {
            model.deleteAllFromDatabase()
            verify(mockRepository).deleteAllFromDatabase()
        }
    }
}