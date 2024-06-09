package fr.esiee.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test (
    @PrimaryKey(autoGenerate = true)
    val testId : Int = 0,
    @ColumnInfo
    val name : String
)