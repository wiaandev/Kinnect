package com.example.kinnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidclassroom.Navigation
import com.example.androidclassroom.viewModels.AuthViewModel
import com.example.kinnect.Screens.LoginScreen
import com.example.kinnect.Screens.RegisterScreen
import com.example.kinnect.ui.theme.KinnectTheme
import com.example.kinnect.ui.theme.poppinsBody

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val authViewModel: AuthViewModel = viewModel(modelClass = AuthViewModel::class.java)

            KinnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    RegisterScreen()
                    Navigation(authViewModel = authViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = poppinsBody
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KinnectTheme {
        Greeting("Android")
    }
}