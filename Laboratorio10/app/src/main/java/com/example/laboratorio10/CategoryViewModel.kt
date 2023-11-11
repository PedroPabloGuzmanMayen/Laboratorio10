package com.example.laboratorio10

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: FirestoreRepository = FirestoreRepository()): ViewModel() {

    val categoriyList: MutableState<List<Categories>> = mutableStateOf(emptyList<Categories>())
    init {
        viewModelScope.launch(Dispatchers.IO){
            val categories = repository.getCategories()
            categoriyList.value = categories
        }
    }
}