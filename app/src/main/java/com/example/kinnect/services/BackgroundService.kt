package com.example.kinnect.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.kinnect.models.Message
import com.example.kinnect.repositories.AuthRepository
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BackgroundService: Service() {

    var onMessageListener: ListenerRegistration? = null

    var authRepository = AuthRepository()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread{
            while (true){
                try {

                    Log.d("AAA Service, ", "running...")

                    if(authRepository.hasUser()){
                        Log.d("AAA service", "user has logged in!")
                        if(onMessageListener == null){
                            startFirestoreListener()
                        } else {
                            Log.e("AAA Service, ", "already listening")
                        }
                    } else {
                        Log.d("AAA service", "user NOT logged in!")
                    }

                    Thread.sleep(15000)
                } catch (e: Exception){
                    onMessageListener = null
                    e.printStackTrace()
                }
            }
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        onMessageListener = null
        Log.d("AAA Service,", "destoyed...")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startFirestoreListener() {
        Log.d("AA start messages", "yebo")

        val collectionRef = Firebase.firestore
            .collectionGroup("messages")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .limit(10)

        onMessageListener = collectionRef.addSnapshotListener { snapshot, e ->
            Log.d("AAA Listening...", "YES!!")
            if(e != null){ // there was an error message
                Log.d("AAA listener went wrong", e.localizedMessage ?: "")
                return@addSnapshotListener
            }

            if (snapshot != null){
                // Converts the result data to our messages
                Log.d("AAA received realtime...", snapshot.documentChanges.size.toString())

                for(dc in snapshot!!.documentChanges) {
                    Log.d("LOGGED IN FOR LOOP", "LOLOS")
                    when(dc.type){
                        DocumentChange.Type.ADDED ->
                            if(authRepository.currentUser?.uid != dc.document.data["fromUserId"].toString()){
                                MyNotification(
                                    this,
                                    "newMessage",
                                    dc.document.data["message"].toString()
                                ).showNotification()}
                        DocumentChange.Type.MODIFIED ->
                            Log.d("AAA service modified", "New message")
                        DocumentChange.Type.REMOVED ->
                            Log.d("AAA service removed", "New message")
                    }
                }
            }
        }
    }

}