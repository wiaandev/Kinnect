package com.example.kinnect.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.epilogueHeading
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(modifier:Modifier = Modifier){

    //    State Variables
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(K_White), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.kinnect_dark), contentDescription = null, modifier = Modifier.size(200.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Create Your Account", style = epilogueHeading, color = K_Charcoal)
        }

        Spacer(modifier = Modifier.size(30.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            OutlinedTextField(
                value = firstName,
                onValueChange = {firstName = it},
                label = { Text(text = "First Name")},
                modifier = Modifier
                    .width(150.dp)
                    .padding(5.dp), shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.size(30.dp))

            OutlinedTextField(
                value = lastName,
                onValueChange = {lastName = it},
                label = { Text(text = "Last Name")},
                modifier = Modifier
                    .width(150.dp)
                    .padding(5.dp), shape = RoundedCornerShape(10.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), shape = RoundedCornerShape(10.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text(text = "Password")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), shape = RoundedCornerShape(10.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text(text = "Confirm Password")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), shape = RoundedCornerShape(10.dp)
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.size(30.dp))

        Text(text = "Already part of Kinnect? Login Here")

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRegisterScreen(){
    KinnectTheme() {
        RegisterScreen()
    }
}