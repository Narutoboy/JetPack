package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack.ui.theme.JetPackTheme
/**
 * Jetpack Compose Native UI toolkit written in kotlin
 * Not part of framework,it is a jetpack Library
 * Basic Building Block : Composable function with @Composable Previously we've View Class
 *
 * Imperative(View) vs Declarative(Compose)
 * What & How        |   What f(data) = UI
 *
 *
 * Inheritance Tree
 *
 * All view are inherit from View Class
 * for large codebase, inheritance become complex
 * OOPS Composition over inheritance (also Single Parent)
 *
 * Recomposition :
 * In simple word - Whenever your state changes, it will recreate the UI
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    sayHello("Akshay")
                }
            }
        }
    }
}

@Composable
fun sayHello(name:String ,modifier: Modifier = Modifier) {
    Text(text ="Yeh Hello $name")
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackTheme {
        Greeting("Android")
    }
}