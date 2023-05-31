package com.example.kinnect.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.repositories.FirestoreRepository
import kotlinx.coroutines.launch

class AuthViewModel (
    private val repository: AuthRepository = AuthRepository()
): ViewModel(){
    val currentUser = repository.currentUser
    val hasUser: Boolean get() = repository.hasUser()

    // instance of our state values
    var authUiState by mutableStateOf(AuthUiState())
        private set
    // function to handle the value updates of my states
    fun handleInputChange(target: String, value: String){
        authUiState = when (target) {
            "loginEmail" -> authUiState.copy(loginEmail = value)
            "loginPassword" -> authUiState.copy(loginPassword = value)
            "registerFirstName" -> authUiState.copy(registerFirstName = value)
            "registerLastName" -> authUiState.copy(registerLastName = value)
            "registerEmail" -> authUiState.copy(registerEmail = value)
            "registerPassword" -> authUiState.copy(registerPassword = value)
            "registerConfirmPassword" -> authUiState.copy(registerConfirmPassword = value)
            else -> authUiState
        }
    }

    //execute register function
    fun createNewUser(context: Context) = viewModelScope.launch {
        try {
            //for validation
            if(authUiState.registerFirstName.isBlank() || authUiState.registerLastName.isBlank() || authUiState.registerEmail.isBlank() || authUiState.registerPassword.isBlank() || authUiState.registerConfirmPassword.isBlank()){
                authUiState = authUiState.copy(errorMessage = "Please fill in the fields")
            } else{
                authUiState = authUiState.copy(isLoading = true) // start loading functionality

                //call our auth
                repository.registerNewUser(
                    authUiState.registerEmail,
                    authUiState.registerPassword
                ) { userId ->

                    if(userId.isNotBlank()){ // we get a userId back
                        //success

                        FirestoreRepository().createUserInDatabase(
                            uid = userId,
                            email = authUiState.registerEmail,
                            firstName = authUiState.registerFirstName,
                            lastName = authUiState.registerLastName
                        ){
                            if(it){
                                Log.d("AAA Register Success: ", userId)
                                Toast.makeText(context, "AAA Registration Completed", Toast.LENGTH_SHORT).show()
                                authUiState = authUiState.copy(authSuccess = true)
                            } else {
                                Toast.makeText(context, "AAA Something went wrong", Toast.LENGTH_SHORT).show()
                                authUiState = authUiState.copy(authSuccess = false)
                            }
                        }
                    } else { // register failed
                        Log.d("Error Registering: ", "Something went wrong")

                        Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show()

                        authUiState = authUiState.copy(authSuccess = false)
                    }
                }
            }
        } catch (e: Exception){
            Log.d("Error Registering: ", e.localizedMessage)
            e.printStackTrace()
        } finally {
            authUiState = authUiState.copy(isLoading = false)
        }
    }

    //execute login function
    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            //for validation
            if(authUiState.loginEmail.isBlank() || authUiState.loginPassword.isBlank()){
                authUiState = authUiState.copy(errorMessage = "Please fill in your username, email & password")
            } else{
                authUiState = authUiState.copy(isLoading = true) // start loading functionality

                //call our auth
                repository.loginUser(
                    authUiState.loginEmail,
                    authUiState.loginPassword
                ) { isCompleted ->

                    if(isCompleted){ // we get a userId back
                        //success
                        Log.d("Login Success: ", "Yay")

                        Toast.makeText(context, "Login Completed", Toast.LENGTH_SHORT).show()

                        authUiState = authUiState.copy(authSuccess = true)
                    } else { // register failed
                        Log.d("Error Login: ", "Something went wrong")

                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()

                        authUiState = authUiState.copy(authSuccess = false)

                    }

                }
            }
        } catch (e: Exception){
            Log.d("Error Registering: ", e.localizedMessage)
            e.printStackTrace()
        } finally {
            authUiState = authUiState.copy(isLoading = false)
        }
    }

    fun logoutUser(context: Context) = viewModelScope.launch {
        repository.signOutUser()
    }
}

// These values are for my front-end state management
data class AuthUiState(

    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val authSuccess: Boolean = false,

    //state values for my login
    val loginEmail: String = "",
    val loginPassword: String = "",

    //state values for my register
    val registerFirstName: String = "",
    val registerLastName: String = "",
    val registerEmail: String = "",
    val registerPassword: String = "",
    val registerConfirmPassword: String = ""

    )