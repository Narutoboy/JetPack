package com.example.jetpack.Udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



class DynamicListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicScreen()


        }
    }

    @Composable
    fun DynamicScreen() {
        GreetingList()
    }

    @Composable
    fun GreetingList(modifier: Modifier = Modifier) {
        val greetingListState = remember { mutableStateListOf<String>("A", "B ", "C", "D", "E") }
        Column {
            for (name in greetingListState) {
                Greeting(name = name)
            }

            Button(onClick = { greetingListState.add("F") }) {
                Text("Add new letter")
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(text = "Hello $name")
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview(modifier: Modifier = Modifier) {
        DynamicScreen()
    }
}