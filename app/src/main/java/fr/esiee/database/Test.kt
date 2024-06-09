package fr.esiee.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
data class Test(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "test_name") val name: String,
    @ColumnInfo(name = "test_protocol") val protocol: String,
    @ColumnInfo(name = "test_response") val response: String,
    @ColumnInfo(name = "test_port") val port: Int?
)
