package ca.russell_waterhouse.hackthecode.database

import androidx.lifecycle.LiveData


class Repository(private val wordDAO: WordDAO) {

    fun getWordsForLevel(level: Int):LiveData<List<Entity>>{
        return wordDAO.getWordsForLevel(level)
    }

    suspend fun insertWord(entity: Entity){
        wordDAO.insertWord(entity)
    }

    suspend fun deleteAllFromDatabase(){
        wordDAO.deleteAllFromDatabase()
    }
}