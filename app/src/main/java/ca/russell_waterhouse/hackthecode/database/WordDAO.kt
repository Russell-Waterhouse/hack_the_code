package ca.russell_waterhouse.hackthecode.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDAO {

    @Query("SELECT * FROM word_table WHERE level = :level")
    fun getWordsForLevel(level: Int): LiveData<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(wordEntity: WordEntity)

    @Query("DELETE FROM word_table")
    suspend fun deleteAllFromDatabase()
}