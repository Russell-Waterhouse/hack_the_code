package ca.russell_waterhouse.hackthecode.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Entity(    @ColumnInfo(name = "level")val level: Int,
                      val word: String,
                      val encodedWordL: String
                    ){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}