package ca.russell_waterhouse.hackthecode.model

import android.content.Context
import androidx.lifecycle.LiveData
import ca.russell_waterhouse.hackthecode.database.WordEntity
import ca.russell_waterhouse.hackthecode.dependency_injection.ActivityScope

@ActivityScope
interface Model {

    suspend fun encodeWord(word: String)

    suspend fun deleteAllFromDatabase()

    fun setLevel(level: Int)

    fun getLevel(): Int

    fun getLiveDataWords(): LiveData<List<WordEntity>>

    fun testString(context: Context, word: String): Boolean

    fun getHint(context: Context):String

    fun getLevelWord(context: Context): String?
}