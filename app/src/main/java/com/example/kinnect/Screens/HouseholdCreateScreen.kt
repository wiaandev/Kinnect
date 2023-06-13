package com.example.kinnect.Screens

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_OrangeLighter
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.ui.theme.poppinsHeading
import com.example.kinnect.viewModels.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("ServiceCast")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HouseholdCreateScreen(
    onNavigateToConversation: () -> Unit,
    onNavigateToJoinHouseholdScreen: () -> Unit,
    viewModel: AuthViewModel = viewModel(),
){

    var householdName by remember {
        mutableStateOf("")
    }

    var hasError = false

    val householdCode = remember { mutableStateOf<String>("") }
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    fun copyToClipboard(){
        clipboardManager.setText(AnnotatedString("${householdName}-${householdCode.value}"))
        Toast.makeText(context, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
    }

    fun generateCode(length: Int): String {
        val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..length)
            .map { charPool.random() }
            .joinToString("")
    }

    fun onCheck(){
        if(householdName == ""){
            hasError = true
        } else {

            onNavigateToConversation.invoke()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(K_White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
              Text(text = "Kinnect your household", style = poppinsHeading, textAlign = TextAlign.Center, color = K_Orange)
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row() {
                Image(
                    painterResource(R.drawable.household),
                    contentDescription = null,
                    modifier = Modifier.width(300.dp)
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row() {
                OutlinedTextField(
                    value = householdName,
                    onValueChange = {householdName = it},
                    label = { Text(text = "Household Name")},
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

            if(hasError){
                Text(text = "Enter your household name!", style = poppinsBody, color = Color.Red)
            }

            if(householdCode.value != ""){

                Spacer(modifier = Modifier.size(20.dp))

                Text(text = "Share code with household members.", style = poppinsBody)

                Spacer(modifier = Modifier.size(10.dp))

                Row(modifier = Modifier.height(50.dp)) {
                    Text(
                        text = "${householdName}-${householdCode.value}",
                        Modifier
                            .background(K_OrangeLighter)
                            .padding(10.dp)
                            .width(200.dp), textAlign = TextAlign.Center, color = K_Charcoal
                    )

                    Spacer(modifier = Modifier.size(10.dp))
                    Button(onClick = { copyToClipboard() }, colors = ButtonDefaults.buttonColors(containerColor = K_Charcoal, K_White), shape = RoundedCornerShape(10.dp)) {
                        Icon(imageVector = Icons.Outlined.ContentCopy, contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
            }


            if(householdCode.value != ""){
                Row() {
                    Button(onClick = { onCheck() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Create Household",
                            style = poppinsH3,
                            modifier = Modifier
                                .padding(10.dp))
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
            } else {
                Row() {
                    Button(
                        onClick = {
                            householdCode.value = generateCode(6)
                            Log.d("CODE: ", householdCode.value)
                            Log.d("CODE: ", householdName)
                            Log.d("AAA USER: ", viewModel.authUiState.toString())
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                        shape = RoundedCornerShape(10.dp)) {
                        Text(text = "Generate Code",
                            style = poppinsH3,
                            modifier = Modifier
                                .padding(10.dp))
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "or", style = poppinsBody, color = K_Charcoal)
                Button(onClick = { onNavigateToJoinHouseholdScreen.invoke() }, colors = ButtonDefaults.buttonColors(containerColor = K_White, K_Orange)) {
                    Text(text = "Join Household", style = poppinsBody)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHouseholdCreateScreen(){
    KinnectTheme() {
        HouseholdCreateScreen(onNavigateToConversation = {}, onNavigateToJoinHouseholdScreen = {})
    }
}