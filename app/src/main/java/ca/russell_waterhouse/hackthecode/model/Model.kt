package ca.russell_waterhouse.hackthecode.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.database.WordDatabase
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderFactory
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderState

class Model (application: Application) {

    private var currentLevel = 1
    private val factory = EncoderFactory()
    private var encoderState: EncoderState = factory.getEncoder(currentLevel)
    private val wordDao = WordDatabase.getDatabaseInstance(application).wordDAO()
    private val repository = Repository(wordDao)


    suspend fun encodeWord(word: String){
        val encodedWord = encoderState.encode(word)
        val entity = Entity(currentLevel, word, encodedWord)
        repository.insertWord(entity)
//        TODO("level 8 does not work with decimal inputs. Ensure that users do not type any numbers in to be encoded")
    }

    fun setLevel(level: Int){
        currentLevel = level
        encoderState = factory.getEncoder(currentLevel)
    }

    fun getLevel(): Int{
        return currentLevel
    }

    fun getLiveDataWords(): LiveData<List<Entity>>{
        return repository.getWordsForLevel(currentLevel)
    }

    fun testString(context: Context, word: String): Boolean{
        return encoderState.testString(context, word)
    }

    fun getHint(context: Context):String{
        return encoderState.getHint(context)
    }
}