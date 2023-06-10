package com.example.kinnect.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kinnect.R
import com.example.kinnect.models.Conversation
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_OrangeLighter
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH2
import com.example.kinnect.ui.theme.poppinsH3
import com.example.kinnect.viewModels.ConversationsViewModel

@Composable
fun ConversationCard(conversation: Conversation, onNavToChat: (String) -> Unit, conversationId: String){

    Row(
        Modifier
            .background(
                color = K_White,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onNavToChat.invoke(conversationId)
                Log.d("AAAA Button Clicked", conversationId)
            }) {
        Column(
            Modifier
                .size(50.dp)
                .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
//            Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
//                RoundedCornerShape(10.dp)
//            )
//            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(conversation.image)
                    .crossfade(true)
                    .build(),
                contentDescription = conversation.title,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
      Column() {
          Text(text = conversation.title, style = poppinsH3, color = K_Charcoal)
          Text(text = conversation.mood, style = poppinsBody, color = K_Charcoal)
      }
    }
}