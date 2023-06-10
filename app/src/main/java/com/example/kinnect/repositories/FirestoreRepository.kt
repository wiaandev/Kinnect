package com.example.kinnect.repositories

import android.util.Log
import com.example.kinnect.models.Conversation
import com.example.kinnect.models.Message
import com.example.kinnect.models.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


const val USER_REF = "users"
const val CONVERSATION_REF = "conversations"

class FirestoreRepository {

    val db = Firebase.firestore

    private val userRef = db.collection(USER_REF)
    private val conversationsRef = db.collection(CONVERSATION_REF)

    fun createUserInDatabase(
        uid: String,
        email: String,
        firstName: String,
        lastName: String,
        onSuccess: (Boolean) -> Unit
    ){
        db.collection("users").document(uid)
            .set(
                User(
                    id = uid,
                    email = email,
                    firstName = firstName,
                    lastName = lastName,
                    profileImg = ""
                )
            )
            .addOnSuccessListener {
                Log.d("AAA Create User Success: ", "Registered!!!!")
                onSuccess.invoke(true)
            }
            .addOnFailureListener{
                Log.d("AAA Create User Failed", it.localizedMessage)
                onSuccess.invoke(false)
            }
    }



    suspend fun getAllConversations(
        onSuccess: (List<Conversation>?) -> Unit
    ){
        Log.d("AAA Getting convos in repo...", "UesQ")
        val conversations = arrayListOf<Conversation>()

        conversationsRef.orderBy("title").get()
            .addOnSuccessListener {
                for(document in it){
                    conversations.add(
                        Conversation(
                            id = document.id,
                            title = document.data["title"].toString(),
                            image = document.data["image"].toString()
                        )
                    )
                }
                Log.d("AAA ConversationData: ", conversations.toString())
                onSuccess(conversations)
            }
            .addOnFailureListener{
                Log.d("AAA Error trying to retrieve conversation: ", it.localizedMessage)
                onSuccess(null)
            }.await()
    }

    suspend fun getUserData(uid: String, onSuccess: (User?) -> Unit){
        userRef.document(uid).get().addOnSuccessListener { document ->
            if(document != null){
                onSuccess.invoke(document.toObject(User::class.java))
                Log.i("USER", "Get SUCCESS",)
            }
        }
            .addOnFailureListener { exception ->
                Log.i("USER", "Get failed with", exception)
                onSuccess.invoke(null)
            }.await()
    }

    suspend fun addNewMessage(
        newMessage: Message,
        chatId: String,
        onSuccess: (Boolean) -> Unit
    ){
        conversationsRef.document(chatId).collection("messages")
            .add(newMessage)
            .addOnSuccessListener {
                Log.d("AAA new message added..", it.id)
                onSuccess.invoke(true)
            }
            .addOnFailureListener{
                Log.d("AAA problem adding message..", it.localizedMessage)
                it.printStackTrace()
                onSuccess.invoke(false)
            }.await()
    }

    suspend fun updateProfileInformation(
        user: User,
        onSuccess: (Boolean) -> Unit
    ){
        userRef.document(user.id ?: "")
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                Log.d("AAA Updated User Success: ", "Updated!!!!")
                onSuccess.invoke(true)
            }
            .addOnFailureListener{
                Log.d("AAA Update User Failed", it.localizedMessage)
                onSuccess.invoke(false)
                it.printStackTrace()
            }.await()
    }
}