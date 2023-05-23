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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_OrangeLight
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsHeading
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ConversationsScreen(modifier: Modifier = Modifier, onNavigateHousehold: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Row() {
            Text(text = "Conversations", style = poppinsHeading, color = MaterialTheme.colorScheme.tertiary)
            Spacer(Modifier.weight(1f))
            Column(
                Modifier
                    .size(70.dp)
                    .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
                Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                )
                )
            }
        }
        
        Spacer(modifier = Modifier.size(20.dp))

        Row(
            Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(K_Orange, K_OrangeLight)
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
                .fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row() {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "Piesang", color = K_White, style = poppinsHeading, textAlign = TextAlign.Center)
                        Text(text = "Household Mood", style = poppinsBody, color = K_White)
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row() {
                    Column(
                        Modifier
                            .size(70.dp)
                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                            RoundedCornerShape(10.dp)
                        )
                        )
                    }
                    Column(
                        Modifier
                            .size(70.dp)
                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                            RoundedCornerShape(10.dp)
                        )
                        )
                    }
                    Column(
                        Modifier
                            .size(70.dp)
                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                            RoundedCornerShape(10.dp)
                        )
                        )
                    }
                    Column(
                        Modifier
                            .size(70.dp)
                            .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
                        Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                            RoundedCornerShape(10.dp)
                        )
                        )
                    }
                }

            }
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