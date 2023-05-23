package com.example.kinnect.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kinnect.R
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_OrangeLighter
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH2
import com.example.kinnect.ui.theme.poppinsH3

@Composable
fun ConversationCard(){
    Row(
        Modifier
            .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(5.dp)) {
        Column(
            Modifier
                .size(50.dp)
                .background(color = Color.Red, shape = RoundedCornerShape(10.dp))) {
            Image(painter = painterResource(id = R.drawable.person), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.clip(
                RoundedCornerShape(10.dp)
            )
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
      Column() {
          Text(text = "Steve", style = poppinsH2, color = MaterialTheme.colorScheme.tertiary)
          Text(text = "Sad", style = poppinsBody, color = MaterialTheme.colorScheme.tertiary)
      }  
    }
}