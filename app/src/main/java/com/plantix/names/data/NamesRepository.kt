package com.plantix.names.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.plantix.names.data.localdatasource.LocalDataSource
import com.plantix.names.data.names.Names
import com.plantix.names.data.remotedatasource.RemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NamesRepository @Inject constructor(private val localDataSource: LocalDataSource) {
    private var _namesList = MediatorLiveData<List<Names>>()

    fun fetchNames() {
        _namesList.addSource(localDataSource.getNames()) {
            if (it.isEmpty()) {
                fetchFromRemote()
            } else {
                _namesList.postValue(it)
            }
        }
    }

    fun getNames(): LiveData<List<Names>> = _namesList

    private fun fetchFromRemote() {
        runBlocking {
            withContext(Dispatchers.IO) {
                val names = RemoteData.fetchNames()
                localDataSource.insertNames(names)
            }
        }
    }
}
