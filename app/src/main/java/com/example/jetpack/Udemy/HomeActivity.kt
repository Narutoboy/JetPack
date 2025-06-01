package com.example.jetpack.Udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingButton("Android")
        }
    }
}
/*Modifier : Order of Modifier matter
*with Style we can used predefine style e.g Material theme and customize by using TextStyle */
@Composable
fun GreetingText(name:String) {
    Text(text = "Hello $name", modifier = Modifier.width(200.dp)
        .height(240.dp)
        .clickable {  }
        .padding(20.dp),
        style = MaterialTheme.typography.bodyLarge)
}


@Composable
fun GreetingButton(name : String, ) {
    Button(onClick = {}) {
        GreetingText("Android ")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewHomeActivity() {
    GreetingButton("Android")
}