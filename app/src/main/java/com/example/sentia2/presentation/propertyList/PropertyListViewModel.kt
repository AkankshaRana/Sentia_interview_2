package com.example.sentia2.presentation.propertyList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sentia2.domain.model.Property
import com.example.sentia2.repository.PropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel
@Inject
constructor(
    private val repository: PropertyRepository
): ViewModel(){

    val propertyList: MutableLiveData<List<Property>> by lazy {
        MutableLiveData<List<Property>>()
    }

    init {
        loadProperties()
    }
    private fun loadProperties(){
        viewModelScope.launch {
            val result = repository.get()
            propertyList.value = result
        }
    }
}