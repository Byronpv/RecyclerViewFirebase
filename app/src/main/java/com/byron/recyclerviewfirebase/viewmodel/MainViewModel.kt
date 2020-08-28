package com.byron.recyclerviewfirebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.byron.recyclerviewfirebase.domain.data.User
import com.byron.recyclerviewfirebase.domain.network.Repository

class MainViewModel: ViewModel() {

    val repository = Repository()

    // Cuando el liveData se setee, va a retornar la lista de usuarios
    fun fetchUserData(): LiveData<MutableList<User>> {

        val mutableData = MutableLiveData<MutableList<User>>()
        repository.getUserData().observeForever{ userList ->
            mutableData.value = userList
        }

        return mutableData
    }


}