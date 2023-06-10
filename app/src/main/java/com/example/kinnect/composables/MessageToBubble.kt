package com.example.kinnect.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinnect.R
import com.example.kinnect.Screens.ChatScreen
import com.example.kinnect.models.Message
import com.example.kinnect.ui.theme.K_Charcoal
import com.example.kinnect.ui.theme.K_Orange
import com.example.kinnect.ui.theme.K_White
import com.example.kinnect.ui.theme.K_WhiteDark
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3

@Composable
fun MessageToBubble (message: Message, modifier: Modifier = Modifier){
    Row(modifier.padding(10.dp), verticalAlignment = Alignment.Bottom) {
        Column(modifier.padding(start = 8.dp, end = 16.dp)) {
            Column(
                modifier
                    .fillMaxWidth()
                    .background(
                        color = K_WhiteDark, shape = RoundedCornerShape(
                            10.dp
                        )
                    ).padding(10.dp), horizontalAlignment = Alignment.End) {
                Text(
                    text = message.message,
                    style= poppinsH3,
                    color = K_Charcoal,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = message.timestamp.toDate().toString(),
                    style= poppinsBody,
                    color = K_Charcoal,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMessageToBubble(){
    KinnectTheme() {
        MessageToBubble(message = Message(), modifier = Modifier)
    }
}
