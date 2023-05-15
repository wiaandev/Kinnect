package com.example.androidclassroom.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinnect.R
import com.example.kinnect.ui.theme.KinnectTheme

@Composable
fun ConversationsScreen(modifier: Modifier = Modifier, onNavigateHousehold: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = "Chats",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
//        Button(onClick = { onSignOut.invoke()}) {
//            Text(text = "Sign Out")
//        }

        Button(onClick = { onNavigateHousehold.invoke()}) {
            Text(text = "Sign Out")
        }


        LazyColumn(){
//            items(10){item ->
//                ConversationCard(Conversation(
//                    title = "Kotlin $item",
//                    image = "https://free4kwallpapers.com/uploads/originals/2021/04/10/android--kotlin-wallpaper.png")
//                )
//            }
        }

    }


}

//@Composable
//fun ConversationCard(modifier: Modifier = Modifier){
//
//    Card(modifier = Modifier
//        .padding(8.dp)
//        .fillMaxWidth()) {
//        Column() {
//
//            AsyncImage(
//                model = ImageRequest.Builder(context = LocalContext.current)
//                    .data("https://free4kwallpapers.com/uploads/originals/2021/04/10/android--kotlin-wallpaper.png")
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                placeholder = painterResource(R.drawable.ic_launcher_foreground),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
//
//            Text(
//                text = "Test",
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.headlineSmall
//            )
//
//        }
//    }
//}

@Preview(showSystemUi = true)
@Composable
fun prevConversationsScreen(){
    KinnectTheme() {
        ConversationsScreen( onNavigateHousehold = {})
    }
}