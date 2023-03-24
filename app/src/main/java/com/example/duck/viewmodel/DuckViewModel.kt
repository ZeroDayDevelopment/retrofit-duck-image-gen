package com.example.duck.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duck.repo.Repository
import com.example.duck.response.PostData
import kotlinx.coroutines.launch

class DuckViewModel(private val repository: Repository):ViewModel() {
    val myResponse: MutableLiveData<PostData> = MutableLiveData()

    fun getDuck(){
        viewModelScope.launch {
            val response = repository.GetDuck()
            myResponse.value = response
        }
    }

}