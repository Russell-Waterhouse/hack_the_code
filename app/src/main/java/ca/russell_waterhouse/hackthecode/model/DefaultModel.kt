package ca.russell_waterhouse.hackthecode.model

import android.content.Context
import androidx.lifecycle.LiveData
import ca.russell_waterhouse.hackthecode.database.Entity
import ca.russell_waterhouse.hackthecode.database.Repository
import ca.russell_waterhouse.hackthecode.dependency_injection.ActivityScope
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderFactory
import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderState
import javax.inject.Inject

@ActivityScope
open class DefaultModel @Inject constructor(
    private val repository: Repository,
    private val factory: EncoderFactory
): Model {

    private var currentLevel = 1
    private var encoderState: EncoderState = factory.getEncoder(currentLevel)


    override suspend fun encodeWord(word: String){
        val encodedWord = encoderState.encode(word)
        val entity = Entity(currentLevel, word, encodedWord)
        repository.insertWord(entity)
    }

    override fun setLevel(level: Int){
        currentLevel = level
        encoderState = factory.getEncoder(currentLevel)
    }

    override fun getLevel(): Int{
        return currentLevel
    }

    override fun getLiveDataWords(): LiveData<List<Entity>>{
        return repository.getWordsForLevel(currentLevel)
    }

    override fun testString(context: Context, word: String): Boolean{
        return encoderState.testString(context, word)
    }

    override fun getHint(context: Context):String{
        return encoderState.getHint(context)
    }

    override fun getLevelWord(context: Context): String {
        return encoderState.getLevelWord(context)
    }

    override suspend fun deleteAllFromDatabase(){
        repository.deleteAllFromDatabase()
    }
}