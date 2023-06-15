package com.example.kinnect.viewModels

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinnect.models.User
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.repositories.FirestoreRepository
import com.example.kinnect.repositories.StorageRepository
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val authRepository: AuthRepository = AuthRepository(),
    private val firestoreRepository: FirestoreRepository = FirestoreRepository(),
    private val storageRepository: StorageRepository = StorageRepository()
): ViewModel() {

    private val hasUser = authRepository.hasUser()
    private val currentUserId = authRepository.getUserId()

    init {
        Log.d("AAA Profile View Model", "INIT")
        getProfileData()
    }

    var profileUiState by mutableStateOf(ProfileUiState())
        private set

    var oldImage: String = ""


    fun handleFirstNameStateChange(value: String){
        profileUiState = profileUiState.copy(firstName = value)
    }

    fun handleLastNameStateChange(value: String){
        profileUiState = profileUiState.copy(lastName = value)
    }

    fun handleProfileImageChange(value: Uri){
        profileUiState = profileUiState.copy(profileImg = value)
    }

    private fun getProfileData() = viewModelScope.launch {
        if(currentUserId.isNotBlank()){
            firestoreRepository.getUserData(currentUserId){
                profileUiState = profileUiState.copy(
                    firstName = it?.firstName ?: "",
                    lastName = it?.lastName ?: "",
                    email = it?.email ?: "",
                    profileImg = Uri.parse(it?.profileImg)

                )
                oldImage = it?.profileImg ?: ""
                Log.d("AAA received user info: ", it.toString())
            }
        }
    }

    fun saveProfileData() = viewModelScope.launch {
        Log.d("AAA Profile States", profileUiState.toString())
        if(hasUser){
            var downloadUrl = oldImage
            // if a new image was selected, upload the new one
            if(oldImage != profileUiState.profileImg.toString() || oldImage.isBlank()){
                Log.d("AAA new image selected...", "YES!")

                storageRepository.uploadImageToStorage(
                    imageUri = profileUiState.profileImg,
                    fileName = "$currentUserId-${profileUiState.email}"
                ) {
                    downloadUrl = it
                }

                Log.d("AAA new image URL", downloadUrl)

                firestoreRepository.updateProfileInformation(
                        uid = currentUserId,
                        firstName = profileUiState.firstName,
                        lastName = profileUiState.lastName,
                        profileImg = downloadUrl
                ){
                    Log.d("AAA Updated User?", it.toString())
                }
            } else {
                firestoreRepository.updateProfileInformation(
                    uid = currentUserId,
                    firstName = profileUiState.firstName,
                    lastName = profileUiState.lastName,
                    profileImg = downloadUrl
                ){
                    Log.d("AAA Updated User?", it.toString())
                }
            }
        }
    }

}

data class ProfileUiState(

    //state values for my profile
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val profileImg: Uri = Uri.EMPTY,

)