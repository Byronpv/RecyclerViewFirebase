package com.byron.recyclerviewfirebase.domain.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.byron.recyclerviewfirebase.domain.data.User
import com.google.firebase.firestore.FirebaseFirestore

class Repository {

    fun getUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        FirebaseFirestore.getInstance().collection("Users").get().addOnSuccessListener { result ->
            val listData = mutableListOf<User>()
            for (document in result){
                val imageUrl = document.getString("imageUrl")
                val nombre = document.getString("nombre")
                val descripcion = document.getString("descripcion")
                val user = User(
                    imageUrl!!,
                    nombre!!,
                    descripcion!!
                )
                listData.add(user)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}