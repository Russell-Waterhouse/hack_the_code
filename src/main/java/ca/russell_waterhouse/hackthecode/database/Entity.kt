package ca.russell_waterhouse.hackthecode.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Entity(@ColumnInfo(name = "level")val level: Int, @ColumnInfo(name = "word")val word: String, @ColumnInfo(name = "encoding")val encodedWordL: String){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id = 0
}