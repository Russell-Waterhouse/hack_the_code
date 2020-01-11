package ca.russell_waterhouse.hackthecode.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.database.WordDatabase
import ca.russell_waterhouse.hackthecode.model.encoding_objects.Encoder
import ca.russell_waterhouse.hackthecode.model.encoding_objects.EncoderFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Model (application: Application) {

    private var currentLevel = 1
    private val factory = EncoderFactory()
    private var encoder: Encoder = factory.getEncoder(currentLevel)
    private val wordDao = WordDatabase.getDatabaseInstance(application).wordDAO()
    private val repository = Repository(wordDao)


    suspend fun encodeWord(word: String){
        val encodedWord = encoder.encode(word)
        val entity = Entity(currentLevel, word, encodedWord)
        repository.insertWord(entity)
    }

    fun setLevel(level: Int){
        currentLevel = level
        encoder = factory.getEncoder(currentLevel)
    }

    fun getLevel(): Int{
        return currentLevel
    }

    fun getLiveDataWords(): LiveData<List<Entity>>{
        return repository.getWordsForLevel(currentLevel)
    }

    fun testString(context: Context, word: String): Boolean{
        return encoder.testString(context, word)
    }

    fun getHint(context: Context):String{
        return encoder.getHint(context)
    }

}