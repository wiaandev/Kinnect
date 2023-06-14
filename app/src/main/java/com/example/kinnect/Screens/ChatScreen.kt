package com.example.kinnect.Screens

import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.R
import com.example.kinnect.composables.MessageFromBubble
import com.example.kinnect.composables.MessageToBubble
import com.example.kinnect.models.Message
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_CharcoalLight
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.K_WhiteDark
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppins
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH2
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.viewModels.AuthViewModel
import com.example.kinnect.viewModels.ChatViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kinnect.viewModels.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
    onNavigateBack: () -> Unit,
    chatId: String?,
    name: String?,
    modifier: Modifier,
    profileViewModel: ProfileViewModel = viewModel(),
){



    val currentUserFrom = "Wiaan"
    val dummyData = listOf<Message>(
        Message(fromUserId = "Leander", from = "Leander", message = "Dis 'n bietjie vieslik maar oraait."),
        Message(from = "Wiaan", message = "Hou jou bek!", fromUserId = "Wiaan"),
        Message(fromUserId = "Leander", from = "Leander", message = "Hello oom"),
        Message(from = "Wiaan", message = "Hou jou bek!", fromUserId = "Wiaan")
    )

    val isChatIdNotBlank = chatId.isNullOrBlank()

    LaunchedEffect(key1 = Unit){
        if(!isChatIdNotBlank){
            viewModel.getRealtimeMessages(chatId ?: "")
            Log.d("AAA launch effect attempt", ".....")
        } else {
            Log.d("AAA chat id error", ".....")
        }
    }

    var newMessage by remember {
        mutableStateOf("")
    }

    val allMessages = viewModel.messageList ?: listOf<Message>()

    Column(modifier.background(K_White).fillMaxSize()) {
        Column(modifier.fillMaxSize()) {
            Row(
                modifier
                    .fillMaxWidth()
                    .background(K_Orange, RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .padding(20.dp)) {
                Column(
                    Modifier
                        .size(70.dp)
                        .background(color = Color.Red, shape = RoundedCornerShape(bottomEnd = 10.dp))
                        .clickable { Log.d("AAA: Going to profile", "YAY") }) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("")
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
                Spacer(modifier.size(10.dp))
                Column() {
                    Text(text = "Steve" , style = poppinsH2, color = K_Charcoal)
                    Text(text = "Brother", style = poppinsH3, color = K_Charcoal)
                }

                Spacer(modifier.size(10.dp))
                Button(
                    onClick = { Log.d("PROFILE GOING", "YAY") },
                    colors = ButtonDefaults.buttonColors(containerColor = K_White, K_Charcoal),
                    shape = RoundedCornerShape(10.dp)) {
                    Text(text = "View Profile",
                        style = poppinsBody,
                        modifier = Modifier
                            .padding(10.dp))
                }
            }

            Spacer(modifier.size(20.dp))

            // Lazy Column Insert Here
            LazyColumn(
                modifier.weight(1f),
                reverseLayout = true
            ){
                items(allMessages){message ->
                    if(viewModel.currentUserId == message.fromUserId){
                        MessageToBubble(message)
                    } else {
                        MessageFromBubble(message)
                    }
                }
            }

            Row(
                modifier
                    .padding(1.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {

                OutlinedTextField(
                    value = newMessage,
                    onValueChange = {newMessage = it},
                    label = { Text(text = "Enter Message...")},
                    modifier = Modifier
                        .padding(5.dp), shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = K_Orange,
                        unfocusedBorderColor = K_CharcoalLight,
                        textColor = K_Charcoal,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Button(
                    onClick = {
                        viewModel.sendNewMessage(newMessage, chatId ?: "")
                        newMessage = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = K_Orange, K_White),
                    shape = RoundedCornerShape(10.dp)) {
                    Icon(imageVector = Icons.Outlined.Send, contentDescription = null)
                }
            }
        }
    }
    }



@Preview(showSystemUi = true)
@Composable
fun PreviewChatScreen(){
    KinnectTheme() {
        ChatScreen( onNavigateBack = {}, modifier = Modifier, chatId = "chat1234", name = "Name")
    }
}