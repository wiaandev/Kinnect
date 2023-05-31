package com.example.kinnect.repositories

import android.util.Log
import com.example.kinnect.models.Conversation
import com.example.kinnect.models.User
import com.google.firebase.firestore.ktx.firestore
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
        conversationsRef.orderBy("title").get()
            .addOnSuccessListener {
                Log.d("AAA ConversationData: ", it.toString())
                onSuccess(it.toObjects(Conversation::class.java))
            }
            .addOnFailureListener{
                Log.d("AAA Error trying to retrieve conversation: ", it.localizedMessage)
                onSuccess(null)
            }.await()
    }
}