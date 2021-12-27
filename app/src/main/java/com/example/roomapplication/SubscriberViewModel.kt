package com.example.roomapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.db.Subscriber
import com.example.roomapplication.db.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository:SubscriberRepository) : ViewModel(){

    val subscribers = repository.subscribers
    val inputName = MutableLiveData<String>()
    val inputemail = MutableLiveData<String>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()
    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputemail.value!!
        insert(Subscriber(0,name,email))
        inputName.value = null
        inputemail.value = null
    }
    fun cleaAllOrDelete(){
        clearAll()
    }

    fun insert(subscriber:Subscriber):Job =
        viewModelScope.launch {
            repository.insert(subscriber) }

    fun update(subscriber:Subscriber):Job =
        viewModelScope.launch {
            repository.update(subscriber) }

    fun delete(subscriber:Subscriber):Job =
        viewModelScope.launch {
            repository.delete(subscriber) }

    fun clearAll():Job =
        viewModelScope.launch {
            repository.deleteAll() }
}