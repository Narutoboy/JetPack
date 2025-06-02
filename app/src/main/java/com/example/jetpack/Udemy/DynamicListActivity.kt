package com.example.jetpack.Udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


val nameList: ArrayList<String> = arrayListOf("A", "B ", "C", "D", "E")

class DynamicListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = nameList)

        }
    }

    @Composable
    fun GreetingList(names: List<String>, modifier: Modifier = Modifier) {
        Column {
            for (name in names) {
                Greeting(name = name)
            }

            Button(onClick = { nameList.add("F") }) {
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
        GreetingList(names = nameList)
    }
}