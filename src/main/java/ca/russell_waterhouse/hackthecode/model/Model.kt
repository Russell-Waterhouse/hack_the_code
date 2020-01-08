package ca.russell_waterhouse.hackthecode.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.database.WordDatabase
import ca.russell_waterhouse.hackthecode.model.encoding_objects.Encoder
import ca.russell_waterhouse.hackthecode.model.encoding_objects.EncoderFactory

class Model (application: Application) {

    private var currentLevel = 1
    private val factory = EncoderFactory()
    private var encoder: Encoder = factory.getEncoder(currentLevel)
    private val wordDao = WordDatabase.getDatabaseInstance(application).wordDAO()
    private val repository = Repository(wordDao)


    fun encodeWord(word: String): String{
        return encoder.encode(word)
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

    fun testString(word: String): Boolean{
        return encoder.testString(word)
    }

    fun getHint(context: Context):String{
        return encoder.getHint(context)
    }

}