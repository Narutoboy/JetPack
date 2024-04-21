package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    layout()
}

@Composable
fun layout() {
    /** For layout : Column, Row, Box
     * Column :  Vertical arrangement
     * Row : Horizontal arrangement */
    //columnExample()
    //rowExample()
    //boxExample()
    listViewItemExample(imgId = R.drawable.ic_launcher_foreground, name = "Akshay", occupation = "Mobile Genius")
}
@Composable
fun listViewItemExample(imgId:Int,name:String,occupation:String) {
Row(Modifier.padding(8.dp)) {
    Image(painter = painterResource(id = imgId),
        contentDescription = "Image",
        modifier = Modifier.size(40.dp),
    )
}
    Column {
        Text(text = name, fontWeight =FontWeight.ExtraBold)
        Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 24.sp)
    }
}

@Composable
fun boxExample() {
    //Box are similar to frameLayout
    Box(contentAlignment = Alignment.TopEnd) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "background")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "foreground")
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
