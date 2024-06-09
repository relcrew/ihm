package fr.esiee.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class TestRepository(application: Application) {
    private val testDao: DaoTest
    private val allTests: MutableLiveData<List<Test>>

    init {
        val db = Room.databaseBuilder(application, TestDb::class.java, "network-monitor").build()
        testDao = db.getTestDao()
        allTests = MutableLiveData()
    }

    fun getAllTests(): LiveData<List<Test>> {
        loadTests()
        return allTests
    }

    private fun loadTests() {
        runBlocking{
            val tests = testDao.getAllTest()
            allTests.postValue(tests)
        }
    }

    suspend fun insert(test: Test) {
        withContext(Dispatchers.IO) {
            testDao.insertTest(test)
            loadTests()
        }
    }
}
