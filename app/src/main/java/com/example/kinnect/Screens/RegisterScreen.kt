package com.example.kinnect.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.ui.theme.KinnectTheme

@Composable
fun RegisterScreen(modifier:Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxSize()) {
        
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRegisterScreen(){
    KinnectTheme() {
        RegisterScreen()
    }
}