package com.plantix.names.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.plantix.names.data.NamesRepository
import com.plantix.names.data.names.Names
import com.plantix.names.ui.NamesListAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: NamesRepository
) : ViewModel() {
    val adapter: NamesListAdapter = NamesListAdapter()
    var names: LiveData<List<Names>>

    init {
        repository.fetchNames()
        names = repository.getNames()
    }

    fun updateNamesList(list: List<Names>) {
        adapter.updateList(list)
    }
}