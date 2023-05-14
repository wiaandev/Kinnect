package com.example.kinnect.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_OrangeLighter
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.ui.theme.poppinsHeading
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HouseholdCreateScreen(onNavigateToConversation: () -> Unit){

    var householdName by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(K_White),
            horizontalAlignment = Alignment.CenterHorizontally,
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
            Spacer(modifier = Modifier.size(30.dp))
            Row() {
                Column() {
                    Text(text = "Send this to your household members", color = K_Charcoal)
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(text = "23vdghs",
                            Modifier
                                .background(K_OrangeLighter)
                                .padding(10.dp)
                                .width(200.dp), textAlign = TextAlign.Center, color = K_Charcoal)
                        Spacer(modifier = Modifier.size(10.dp))
                        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = K_Charcoal, K_White), shape = RoundedCornerShape(10.dp)) {
                            Icon(imageVector = Icons.Outlined.ContentCopy, contentDescription = null)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row() {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White), shape = RoundedCornerShape(10.dp)) {
                    Text(text = "Login",
                        style = poppinsH3,
                        modifier = Modifier
                            .padding(10.dp))
                }
            }
            Spacer(modifier = Modifier.size(30.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "or", style = poppinsBody, color = K_Charcoal)
                Button(onClick = { onNavigateToConversation.invoke() }, colors = ButtonDefaults.buttonColors(containerColor = K_White, K_Orange)) {
                    Text(text = "Go to Conversations", style = poppinsBody)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHouseholdCreateScreen(){
    KinnectTheme() {
        HouseholdCreateScreen(onNavigateToConversation = {})
    }
}