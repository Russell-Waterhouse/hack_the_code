package ca.russell_waterhouse.hackthecode.database

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.MediumTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import java.util.concurrent.CountDownLatch
import kotlin.collections.mutableListOf as mutableListOf1

class WordDatabaseTest {


    private lateinit var db : WordDatabase
    private  lateinit var wordDAO: WordDAO

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, WordDatabase::class.java).build()
        wordDAO = db.wordDAO()
    }


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun wordDAO() {
        assertNotNull(db)
        assertNotNull(wordDAO)
    }

    @Test
    fun testInsertionRetrieval(){
//        Insertion
        val testData = Entity(1, "String", "Encoded_String")
        runBlocking {
            wordDAO.insertWord(testData)
        }

//        Retrieval
        val liveList = wordDAO.getWordsForLevel(1)
        val countDownLatch = CountDownLatch(1)
        var retrievedData : Entity? = null
        val observer = object : Observer<List<Entity>> {
            override fun onChanged(t: List<Entity>?) {
                if(t != null && t.isNotEmpty()){
                    retrievedData = t[0]
                    countDownLatch.countDown()
                }
                liveList.removeObserver(this)
            }
        }
        liveList.observeForever(observer)
        countDownLatch.await()
        assertEquals(testData, retrievedData)
    }

    @MediumTest
    @Test
    fun testInsertionRetrievalMedium(){
        var i = 0
        val listOfEntries = mutableListOf1<Entity>()
        while (i < 100){
            val string = i.toString()
            val testData = Entity(1, string, string)
            listOfEntries.add(testData)
            runBlocking {
                wordDAO.insertWord(testData)
            }
            i++
        }
        val countDownLatch = CountDownLatch(1)
        val liveList = wordDAO.getWordsForLevel(1)
        var retrievedData : List<Entity>? = null
        val observer = object : Observer<List<Entity>> {
            override fun onChanged(t: List<Entity>?) {
                if(t != null && t.isNotEmpty()){
                    retrievedData = t
                    countDownLatch.countDown()
                }
                liveList.removeObserver(this)
            }
        }
        liveList.observeForever(observer)
        countDownLatch.await()
        assertEquals(listOfEntries, retrievedData)
    }

}