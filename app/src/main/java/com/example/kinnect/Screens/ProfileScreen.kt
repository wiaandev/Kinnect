package com.example.kinnect.Screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kinnect.R
import com.example.kinnect.repositories.AuthRepository
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.ui.theme.poppinsHeading
import com.example.kinnect.viewModels.UserViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinnect.viewModels.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navOnSignOut: () -> Unit,
    navBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
    profileViewModel: ProfileViewModel = viewModel()
){

    val profileUiState = profileViewModel.profileUiState

    val user = remember (viewModel.profile){
        derivedStateOf {viewModel.profile }
    }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {uri ->
            if (uri != null) {
                profileViewModel.handleProfileImageChange(uri)
            }
        }
    )

    Column(
        modifier
            .background(K_White)
            .fillMaxSize()) {
        Row(
            modifier
                .fillMaxWidth()
                .background(K_Orange)) {
            Spacer(modifier.size(10.dp))
            Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier.fillMaxWidth()) {
                    Button(onClick = { navBack.invoke() }) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null, tint = K_White)
                    }
                }
                Button(onClick = { singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )}) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(profileUiState.profileImg ?: "/")
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.person),
                        modifier = Modifier
                            .size(100.dp)
                            .background(color = K_Charcoal, shape = RoundedCornerShape(10.dp))
                            .clip(RoundedCornerShape(10.dp)),
                    )
                }
                Text(text = "${user.value?.firstName} ${user.value?.lastName}", style = poppinsHeading, color = K_Charcoal)
                Text(text = "Add household relationship", style = poppinsH3, color = K_Charcoal)
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Change Mood", style = poppinsBody, color = K_White)
                }
            }
        }
        Column(modifier.padding(20.dp)) {

            OutlinedTextField(
                value = profileUiState.firstName,
                onValueChange = {profileViewModel.handleFirstNameStateChange(it)},
                label = { Text(text = "First Name")},
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

            OutlinedTextField(
                value = profileUiState.lastName,
                onValueChange = {""},
                label = { Text(text = "Last Name")},
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

            OutlinedTextField(
                value = profileUiState.email,
                onValueChange = {""},
                label = { Text(text = "Email")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp), shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = K_Orange,
                    unfocusedBorderColor = K_Orange,
                    textColor = K_Charcoal
                ),
                enabled = false,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Button(
                onClick = {
                          profileViewModel.saveProfileData()
                          },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                shape = RoundedCornerShape(10.dp)) {
                Text(text = "Save Profile",
                    style = poppinsH3,
                    modifier = Modifier
                        .padding(10.dp))
            }

            //TODO: Add Profile Image Feature
            Button(onClick = { AuthRepository().signOutUser(); navOnSignOut.invoke()}, colors = ButtonDefaults.buttonColors(containerColor = K_White, K_Orange)) {
                Text(text = "Sign Out", style = poppinsBody, color = K_Orange)
            }
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