package ca.russell_waterhouse.hackthecode.database

import androidx.lifecycle.LiveData


class Repository(private val wordDAO: WordDAO) {

    fun getWordsForLevel(level: Int):LiveData<List<Entity>>{
        return wordDAO.getWordsForLevel(level)
    }

    fun insertWord(entity: Entity){
        TODO("need more time to get concurrency correct on this")
    }
}