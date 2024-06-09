package fr.esiee.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities=[
    Test::class
], version= 1)

abstract class TestDb : RoomDatabase(){
    abstract fun getTestDao() : DaoTest
}