package com.example.kinnect.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.viewModels.AuthViewModel
import com.example.kinnect.R
import com.example.kinnect.services.MyNotification
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppins
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.ui.theme.poppinsHeading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier:Modifier = Modifier,
    hasError: Boolean = false,
    onNavigateToRegister:() -> Unit,
    authViewModel: AuthViewModel,
    onNavToConversations: () -> Unit
){



    val focusManager = LocalFocusManager.current
    val showPassword = remember {
        mutableStateOf(false)
    }

    //get our values from viewmodel
    val authUiState = authViewModel?.authUiState
    val error = authUiState?.errorMessage != null
    val context = LocalContext.current

    //    State Variables

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()


    Column(modifier = Modifier
        .fillMaxSize()
        .background(K_White)) {
        Column(modifier = Modifier
            .padding(20.dp)
            .verticalScroll(state = scrollState), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.kinnect_dark), contentDescription = null, modifier = Modifier.size(200.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Welcome Back", style = poppinsHeading, color = K_Charcoal)
            }

            Spacer(modifier = Modifier.size(30.dp))


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                OutlinedTextField(
                    value = authUiState?.loginEmail ?: "",
                    onValueChange = {authViewModel.handleInputChange("loginEmail", it)},
                    label = { Text(text = "Email")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_Orange,
                        textColor = K_Charcoal
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                OutlinedTextField(
                    value = authUiState?.loginPassword ?: "",
                    onValueChange = {authViewModel.handleInputChange("loginPassword", it)},
                    label = { Text(text = "Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_Orange,
                        focusedLabelColor = K_Orange,
                        textColor = K_Charcoal
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, autoCorrect = true, imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions (
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    singleLine = true,
                    isError = hasError,
                    visualTransformation = if(showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val (icon, iconColor) = if(showPassword.value){
                            Pair(
                                Icons.Outlined.Visibility,
                                colorResource(id = R.color.charcoal)
                            )
                        } else {
                            Pair(Icons.Outlined.VisibilityOff, colorResource(id = R.color.charcoal))
                        }
                        IconButton(onClick = {showPassword.value = !showPassword.value}) {
                            Icon(icon, contentDescription = null, tint= iconColor)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            if(error){
                Text(text = authUiState?.errorMessage.toString(), color = Color.Red)
            }


            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = { authViewModel?.loginUser(context) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                shape = RoundedCornerShape(10.dp)) {
                Text(text = "Login",
                    style = poppinsH3,
                    modifier = Modifier
                        .padding(10.dp))
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "New to Kinnect?", style = poppinsBody, color = K_Charcoal)
                Spacer(modifier = Modifier.size(10.dp))
                ClickableText(text = AnnotatedString("Create Your Account"), onClick = {onNavigateToRegister.invoke()}, style = TextStyle(color = K_Orange, fontFamily = poppins))
            }


            Spacer(modifier = Modifier.size(10.dp))

        }

        LaunchedEffect(key1 = authViewModel.hasUser) {
            if (authViewModel.hasUser){
                Log.d("AAA!!!", "LaunchedEffect Running")
                onNavToConversations.invoke()
            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen(){
    KinnectTheme() {
        LoginScreen(onNavigateToRegister = {}, authViewModel = AuthViewModel(), onNavToConversations = {})
    }
}