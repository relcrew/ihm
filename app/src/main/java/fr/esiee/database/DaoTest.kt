package fr.esiee.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoTest {
    @Insert
    suspend fun insertTest(vararg test: Test)

    @Query("SELECT * FROM tests")
    suspend fun getAllTest(): List<Test>

    @Update
    suspend fun updateTest(vararg test: Test)

    @Delete
    suspend fun deleteTest(test: Test)

}

