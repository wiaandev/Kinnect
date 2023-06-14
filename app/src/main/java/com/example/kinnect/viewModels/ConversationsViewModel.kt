package com.example.kinnect.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinnect.models.Conversation
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.repositories.FirestoreRepository
import kotlinx.coroutines.launch

class ConversationsViewModel(
    private val repository: FirestoreRepository = FirestoreRepository(),
    private val authRepository: AuthRepository = AuthRepository()
):ViewModel() {

    private val _convoList = mutableStateListOf<Conversation>()
    val convoList: MutableList<Conversation> get() = _convoList

    val currentUser = authRepository.getUserId()

    //get conversations on init
    init {
        getConversations()
    }

    fun getConversations() = viewModelScope.launch{
        repository.getAllConversations(currentUser) { data ->
            if(data != null){
                for(document in data){
                    _convoList.add(document)
                }
            }
        }
    }
}