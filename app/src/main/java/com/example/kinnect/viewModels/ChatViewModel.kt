package com.example.kinnect.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinnect.models.Message
import com.example.kinnect.models.User
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.repositories.FirestoreRepository
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class ChatViewModel (
    private val repository: FirestoreRepository = FirestoreRepository()
): ViewModel() {
    private val _messageList = mutableStateListOf<Message>()
    val messageList: List<Message> = _messageList

    var messageListener: ListenerRegistration? = null

    private var currentUser: User? = null
    var currentUserId = ""

    init {
        getCurrentProfile()
    }

    private fun getCurrentProfile() = viewModelScope.launch {
        currentUserId = AuthRepository().getUserId()

        if(currentUserId.isNotBlank()){
            repository.getUserData(currentUserId){
                currentUser = it
                Log.d("AAA received user info", it.toString())
            }
        }
    }

    fun sendNewMessage(body: String, chatId: String) = viewModelScope.launch {
        if(body.isNotBlank() && chatId.isNotBlank()){

            var sentMessage = Message(
                message = body,
                from = currentUser?.firstName ?: "",
                fromUserId = currentUserId,
                fromUserProfilePic = currentUser?.profileImg ?: ""
            )

            repository.addNewMessage(
                newMessage = sentMessage,
                chatId = chatId
            ){
                    Log.d("AAA added message success", it.toString())
            }
        }
    }

    fun getRealtimeMessages(chatId: String) {
        Log.d("AA start messages", chatId)

        val collectionRef = Firebase.firestore
            .collection("conversations")
            .document(chatId)
            .collection("messages")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .limit(50)

        messageListener = collectionRef.addSnapshotListener { snapshot, e ->
            Log.d("AAA Listening...", "YES!!")
            if(e != null){ // there was an error message
                Log.d("AAA listener went wrong", e.localizedMessage ?: "")
                return@addSnapshotListener
            }

            if (snapshot != null){
                // Converts the result data to our messages
                Log.d("AAA received realtime...", snapshot.toString())

                _messageList.clear() // first clear the data

                //then add the new data
                for(document in snapshot){
                    _messageList.add(document.toObject(Message::class.java))
                }
                Log.d("AAA received new messages: ", snapshot.toString())
            }
        }
    }

    override fun onCleared() {
        Log.d("AAA Stop view model...", "YES!")
        messageListener?.remove()
        messageListener = null
    }


}