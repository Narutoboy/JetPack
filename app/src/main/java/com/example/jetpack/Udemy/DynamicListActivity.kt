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

/**State Hoisting : is moving a composable state to its called,
 * making the composable stateless and controlled by its parent
 *
 *
 *
 * */

class DynamicListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicScreen()


        }
    }

    @Composable
    fun DynamicScreen() {
        val greetingListState = remember { mutableStateListOf<String>("A", "B ", "C", "D", "E") }
        GreetingList(greetingListState, buttonClick = { greetingListState.add("F") })
    }

    @Composable
    fun GreetingList(
        nameList: List<String>,
        buttonClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {

        Column {
            for (name in nameList) {
                Greeting(name = name)
            }

            Button(onClick = buttonClick) {
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