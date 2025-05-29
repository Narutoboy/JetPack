package com.example.jetpack.Udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingButton("Android")
        }
    }
}

@Composable
fun GreetingText(name:String) {
    Text(text = "Hello $name")
}


@Composable
fun GreetingButton(name : String, ) {
    Button(onClick = {}) {
        GreetingText("Android ")
        GreetingText(" From Youtube ")
    }
}

@Preview
@Composable
fun DefaultPreviewHomeActivity() {
    GreetingButton("Android")
}