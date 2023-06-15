package com.example.kinnect.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kinnect.R
import com.example.kinnect.composables.Badge
import com.example.kinnect.composables.ConversationCard
import com.example.kinnect.models.Conversation
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_OrangeLight
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.K_WhiteDark
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsHeading
import com.example.kinnect.viewModels.AuthViewModel
import com.example.kinnect.viewModels.ConversationsViewModel
import com.example.kinnect.viewModels.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationsScreen(
    modifier: Modifier = Modifier,
    onNavigateHousehold: () -> Unit,
    authViewModel: AuthViewModel,
    onNavToProfile: () -> Unit,
    onNavToChat: (chatId: String) -> Unit,
    convoViewModel: ConversationsViewModel = viewModel(),
    profileViewModel: ProfileViewModel = viewModel()
){

    val allConversations = convoViewModel.convoList ?: listOf<Conversation>()
    val authUiState = authViewModel?.authUiState
    val error = authUiState?.errorMessage != null
    val context = LocalContext.current

    Column(
        Modifier
            .background(K_White)
            .fillMaxSize()) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row() {
            Text(text = "Conversations", style = poppinsHeading, color = K_Charcoal)
            Spacer(Modifier.weight(1f))
            Column(
                Modifier
                    .size(70.dp)
                    .background(color = Color.Red, shape = RoundedCornerShape(10.dp))
                    .clickable { onNavToProfile.invoke() }) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(profileViewModel.profileUiState.profileImg)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
        
        Spacer(modifier = Modifier.size(20.dp))

//        Row(
//            Modifier
//                .background(
//                    brush = Brush.horizontalGradient(
//                        listOf(K_Orange, K_OrangeLight)
//                    ),
//                    shape = RoundedCornerShape(10.dp)
//                )
//                .padding(10.dp)
//                .fillMaxWidth()
//                ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)) {
//                Row() {
//                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//                        Text(text = "Duvenhage", color = K_White, style = poppinsHeading, textAlign = TextAlign.Center)
//                        Text(text = "Household Mood", style = poppinsBody, color = K_White)
//                        LinearProgressIndicator(progress = 0.7f, color = K_Charcoal, modifier = Modifier.height(10.dp))
//                    }
//                }
//                Spacer(modifier = Modifier.size(20.dp))
//                Badge()
//                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
//                    Column(
//                        Modifier
//                            .size(50.dp)
//                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
//                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
//                            RoundedCornerShape(10.dp)
//                        )
//                        )
//                    }
//                    Column(
//                        Modifier
//                            .size(50.dp)
//                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
//                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
//                            RoundedCornerShape(10.dp)
//                        )
//                        )
//                    }
//                    Column(
//                        Modifier
//                            .size(50.dp)
//                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
//                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
//                            RoundedCornerShape(10.dp)
//                        )
//                        )
//                    }
//                    Column(
//                        Modifier
//                            .size(50.dp)
//                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
//                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
//                            RoundedCornerShape(10.dp)
//                        )
//                        )
//                    }
//                }
//
//            }
//            }
        
        Spacer(modifier = Modifier.size(20.dp))


        LazyColumn(){
            items(allConversations){conversation ->
                Spacer(modifier = Modifier.size(5.dp))
                ConversationCard(Conversation(
                    firstName = conversation.firstName,
                    lastName = conversation.lastName,
                    email = conversation.email,
                    image = conversation.image,
                    mood = conversation.mood,
                ), onNavToChat = onNavToChat,
                conversationId = conversation.userId)
                Spacer(modifier = Modifier.size(5.dp))
                Divider(color = K_WhiteDark, thickness = 1.dp)
            }
        }

    }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewConversationsScreen(){
    KinnectTheme() {
        ConversationsScreen( onNavigateHousehold = {}, authViewModel = AuthViewModel(), onNavToProfile = {}, onNavToChat = {})
    }
}