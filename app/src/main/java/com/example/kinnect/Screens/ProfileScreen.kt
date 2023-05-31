package com.example.kinnect.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.ui.theme.KinnectTheme

@Composable
fun ProfileScreen(
    navOnSignOut: () -> Unit,
    navBack: () -> Unit,
    modifier: Modifier = Modifier
){
    Column {


        Button(
            onClick = { navBack.invoke()},
            border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)) {
            Text(
                text="Back",
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

        Text(text = "My Profile")

        //TODO: Add Profile Image Feature
        Button(
            onClick = { AuthRepository().signOutUser(); navOnSignOut.invoke()},
            border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)) {
            Text(
                text="Sign Out",
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewProfileScreen(){
    KinnectTheme {
        ProfileScreen(navBack = {}, navOnSignOut = {})
    }
}