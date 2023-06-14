package com.example.kinnect.composables

import android.util.Log
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
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody
import com.example.kinnect.ui.theme.poppinsH3
import java.text.DateFormat.getDateTimeInstance
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun MessageFromBubble (message: Message, modifier: Modifier = Modifier){

    val timestamp = message.timestamp
    val milliseconds = timestamp.seconds * 1000 + timestamp.nanoseconds / 1000000
    val sdf = getDateTimeInstance()
    val netDate = Date(milliseconds)
    val date = sdf.format(netDate).toString()
    Log.d("TAG170", date)

    Row(modifier.padding(10.dp), verticalAlignment = Alignment.Bottom) {
//        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null,
//            modifier
//                .size(40.dp)
//                .clip(
//                    CircleShape
//                )
//                .background(K_Orange)
//        )
        Column(modifier.padding(start = 8.dp, end = 16.dp)) {
            Column(
                modifier
                    .fillMaxWidth(0.9f)
                    .background(
                        color = K_Orange, shape = RoundedCornerShape(
                            10.dp
                        )
                    ).padding(10.dp)) {
                Text(
                    text = message.message,
                    style= poppinsH3,
                    color = K_White,
                )
                Text(
                    text = date,
                    style= poppinsBody,
                    color = K_Charcoal,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMessageFromBubble(){
    KinnectTheme() {
        MessageFromBubble(message = Message(), modifier = Modifier)
    }
}
