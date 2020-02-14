package ca.russell_waterhouse.hackthecode.database

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RepositoryTest {

    private lateinit var repository: Repository
    private lateinit var mockDAO: WordDAO

    @Before
    fun setup(){
        mockDAO = mock(WordDAO::class.java)
        repository = Repository(mockDAO)
    }

    @Test
    fun getWordsForLevel() {
        repository.getWordsForLevel(1)
        verify(mockDAO).getWordsForLevel(1)
    }

    @Test
    fun insertWord() {
        runBlocking {
            val testEntity = WordEntity(1, "word", "encoded word")
            repository.insertWord(testEntity)
            verify(mockDAO).insertWord(testEntity)
        }
    }

    @Test
    fun deleteAllFromDatabase() {
        runBlocking {
            repository.deleteAllFromDatabase()
            verify(mockDAO).deleteAllFromDatabase()
        }
    }
}