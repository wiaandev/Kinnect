package com.example.kinnect.Screens

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.ui.theme.poppinsHeading
import com.example.kinnect.viewModels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    hasError: Boolean = false,
    onNavigateToLogin: () -> Unit,
    onNavigateToConversations: () -> Unit,
    authViewModel: AuthViewModel = viewModel(),
){

    val authUiState = authViewModel?.authUiState
    val error = authUiState?.errorMessage != null
    val context = LocalContext.current

    val focusManager = LocalFocusManager.current
    val showPassword = remember {
        mutableStateOf(false)
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
                Text(text = "Create Your Account", style = poppinsHeading, color = K_Charcoal)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                OutlinedTextField(
                    value = authUiState?.registerFirstName ?: "",
                    onValueChange = {authViewModel.handleInputChange("registerFirstName", it)},
                    label = { Text(text = "First Name")},
                    modifier = Modifier
                        .width(170.dp)
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_Orange,
                        textColor = K_Charcoal
                    )
                )

                Spacer(modifier = Modifier.size(10.dp))

                OutlinedTextField(
                    value = authUiState?.registerLastName ?: "",
                    onValueChange = {authViewModel.handleInputChange("registerLastName", it)},
                    label = { Text(text = "Last Name")},
                    modifier = Modifier
                        .width(170.dp)
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_Orange,
                        textColor = K_Charcoal
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                OutlinedTextField(
                    value = authUiState?.registerEmail ?: "",
                    onValueChange = {authViewModel.handleInputChange("registerEmail", it)},
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
                    value = authUiState?.registerPassword ?: "",
                    onValueChange = { authViewModel.handleInputChange("registerPassword", it)},
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

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

                OutlinedTextField(
                    value = authUiState?.registerConfirmPassword ?: "",
                    onValueChange = {authViewModel.handleInputChange("registerConfirmPassword", it)},
                    label = { Text(text = "Confirm Password")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_Orange,
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
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = { authViewModel.createNewUser(context) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                shape = RoundedCornerShape(10.dp)) {
                Text(text = "Register",
                    style = poppinsH3,
                    modifier = Modifier
                        .padding(10.dp))
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Already part of Kinnect?", style = poppinsBody, color = K_Charcoal)
                Button(onClick = { onNavigateToLogin.invoke() }, colors = ButtonDefaults.buttonColors(containerColor = K_White, K_Orange)) {
                    Text(text = "Login Here", style = poppinsBody)
                }
            }


        }


    }

    LaunchedEffect(key1 = authViewModel.hasUser) {
        if (authViewModel.hasUser){
            onNavigateToConversations.invoke()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRegisterScreen(){
    KinnectTheme() {
        RegisterScreen(onNavigateToLogin = {}, authViewModel = AuthViewModel(), onNavigateToConversations = {})
    }
}