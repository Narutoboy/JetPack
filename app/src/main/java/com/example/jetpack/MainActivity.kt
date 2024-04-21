package com.example.jetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
 *
 * XML vs Compose
 * setContentView(R.id.layout) || setContent{lambda}
 * Parent :AppCompatActivity  || ComponentActivity
 *
 * we can intermix the view & compose with
 * <ComposeView> &  composeView.findViewById().setContent
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                }
            }
        }
    }
}

@Composable
fun textCompose(name: String, modifier: Modifier = Modifier) {
    Surface {
        Text(
            text = "Yeh Hello $name",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    // imageCompose()
    //textCompose(name = "Akshay")
    //buttonCompose("Click Me")
    //textFieldCompose()
    //layout()
    //previewItem()
    recomposeExample()
}

@Composable
fun layout() {
    /** For layout : Column, Row, Box
     * Column :  Vertical arrangement
     * Row : Horizontal arrangement */
    //columnExample()
    //rowExample()
    //boxExample()
    /*listViewItemExample(
        imgId = R.drawable.ic_launcher_foreground,
        name = "Akshay",
        occupation = "Mobile Genius"
    )*/
    //modifierExample()
    circularImage()
}

@Composable
fun circularImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Blue, CircleShape),
        contentDescription = "Sharingan"
    )
}

@Composable
fun modifierExample() {
    /* Modifier :
   * To modify size,display, appearance & behaviour of the composable
   * Size background color,padding, click Handler
   * Composition over inheritance
   * can be chained and sequence matter here
   *
   * To make your custom composable function, you should have modifier :Modifier
   * and in your function chaining.
   * */
    Text(
        text = "Hello",
        color = Color.White,
        modifier = Modifier
            .clickable { }
            .background(Color.Blue)
            .size(200.dp)
            .padding(8.dp)
            .border(4.dp, Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow),
    )
}


@Composable
fun listViewItemExample(imgId: Int, name: String, occupation: String, modifier: Modifier) {
    Row(modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "Image",
            modifier = Modifier.size(40.dp),
        )
    }
    Column {
        Text(text = name, fontWeight = FontWeight.ExtraBold)
        Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 24.sp)
    }
}

@Composable
fun boxExample() {
    //Box are similar to frameLayout
    Box(contentAlignment = Alignment.TopEnd) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "background"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "foreground"
        )
    }
}

@Composable
fun rowExample() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "C", fontSize = 24.sp)
        Text(text = "D", fontSize = 24.sp)
    }
}

@Composable
fun columnExample() {
    /*Arragement : how space will be divided between child element*/
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }
}

@Composable
fun textFieldCompose() {
    val state = remember { mutableStateOf("") }
    TextField(value = state.value,
        onValueChange = { state.value = it },
        label = { Text(text = "Label text") })
}

@Composable
private fun imageCompose() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Main Icon",
        colorFilter = ColorFilter.tint(Color.Red),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun buttonCompose(title: String) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = title)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Click me"
        )
    }
}

/**Recomposition :
 * Whenever your state(data) change it'll recreate the UI
 *
 * Compose function can execute in any order
 * Compose function can run in parallel
 * compose function should be pure function: should not have side effect
 * Re compostion skips as many composable and lambda as possible
 * Recompostion is optimistic and may be canceled
 * A composable function might run quite frequently ,as often as every frame of an animation
 * */

@Composable
fun recomposeExample(modifier: Modifier = Modifier) {
    val state = remember { mutableStateOf(0.0) }
    Log.d("TAG", "recomposeExample: Logged during Initial composition")
    Button(onClick = { state.value = Math.random() }) {
        Log.d("TAG", "recomposeExample: Logged during both Composition and Recomposition")
        Text(text = state.value.toString())
    }
}