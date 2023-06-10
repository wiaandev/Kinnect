package com.example.kinnect.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinnect.models.User
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.repositories.FirestoreRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: FirestoreRepository = FirestoreRepository(),
    authRepository: AuthRepository = AuthRepository()
):ViewModel() {
    private val PROFILEDATA = mutableStateOf<User?>(null)
    val profile: User? get() = PROFILEDATA.value
    private val userId = authRepository.getUserId()
    private var isInitialised = false


    init{
        if(!isInitialised){
            getUserInformation()
            isInitialised = true
            Log.d("AAA WE GOT THE PROFILE INFO", "OH YEAH")
        }
    }

    private fun getUserInformation() = viewModelScope.launch {
        repository.getUserData(userId){ data ->
            data?.let {
                PROFILEDATA.value = it
            }
        }
    }
}
