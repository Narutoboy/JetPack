package com.example.jetpack.Udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**State Hoisting : is moving a composable state to its called,
 * making the composable stateless and controlled by its parent
 *
 *
 *
 * */

class DynamicListActivity : ComponentActivity() {
    val viewModel = DynamicListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicScreen(viewModel = viewModel)


        }
    }

    @Composable
    fun DynamicScreen(viewModel: DynamicListViewModel = DynamicListViewModel()) {

        val textFieldState = viewModel.textFieldState.observeAsState("")
        GreetingMessage(
            textFieldValue = textFieldState.value,
            textFieldValueChange = { a -> viewModel.onTextChanged(a) })
    }

    @Composable
    fun GreetingMessage(
        textFieldValue: String,
        textFieldValueChange: (newValue: String) -> Unit
    ) {

        Column {

            TextField(value = textFieldValue, onValueChange = textFieldValueChange)

            Button(onClick = { }) {
                Text("$textFieldValue")
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