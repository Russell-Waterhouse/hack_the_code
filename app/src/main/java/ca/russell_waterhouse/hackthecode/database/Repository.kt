package ca.russell_waterhouse.hackthecode.database

import androidx.lifecycle.LiveData
import javax.inject.Inject


open class Repository @Inject constructor(private val wordDAO: WordDAO) {

    open fun getWordsForLevel(level: Int):LiveData<List<Entity>>{
        return wordDAO.getWordsForLevel(level)
    }

    open suspend fun insertWord(entity: Entity){
        wordDAO.insertWord(entity)
    }

    open suspend fun deleteAllFromDatabase(){
        wordDAO.deleteAllFromDatabase()
    }
}