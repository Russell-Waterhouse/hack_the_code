package ca.russell_waterhouse.hackthecode.database

import androidx.lifecycle.LiveData
import javax.inject.Inject


open class Repository @Inject constructor(private val wordDAO: WordDAO) {

    open fun getWordsForLevel(level: Int):LiveData<List<WordEntity>>{
        return wordDAO.getWordsForLevel(level)
    }

    open suspend fun insertWord(wordEntity: WordEntity){
        wordDAO.insertWord(wordEntity)
    }

    open suspend fun deleteAllFromDatabase(){
        wordDAO.deleteAllFromDatabase()
    }
}