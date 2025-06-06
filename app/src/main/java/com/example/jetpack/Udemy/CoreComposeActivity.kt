package com.example.jetpack.Udemy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**Surface: like CardView/ LinearLayout, surface is container used for background color, elevation, grouping
 * [wrapContentSize] by default Center Align,we can change with Alignment.CenterStart
 *
 * Column : to arrange in vertical manner
 * Row : to arrange in horizontal manner
 * Box : to arrange in any order/ or in top of each other
 *
 *
 * Row having horizontal Arrangement and vertical Alignment
 * Column having vertical Arrangement and horizontal Alignment
 * */
class CoreComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Surface(color = Color.Yellow, modifier = Modifier.fillMaxSize()) {
            /* Row(horizontalArrangement = Arrangement.SpaceBetween,
                 verticalAlignment = Alignment.CenterVertically ) {
                 HorizonalColoredBox()
                 HorizonalColoredBox(color=Color.Green)
                 HorizonalColoredBox(color=Color.Red)

             }*/

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColoredSquare()
                    ColoredSquare(color = Color.Cyan)

                }
                ColorBox()
                ColorBox(color = Color.Green)
                ColorBox(color = Color.Red)
            }


        }

    }

    @Composable
    private fun HorizonalColoredBox(color: Color = Color.Blue) {
        Surface(
            color = color, modifier = Modifier
                .width(100.dp)
                .height(600.dp)
        ) {
            Text(
                text = "Hello ",
                style = MaterialTheme.typography.displayLarge
            )

        }
    }

    @Composable
    private fun ColorBox(color: Color = Color.Blue) {
        Surface(
            color = color, modifier = Modifier
                .width(350.dp)
                .height(100.dp)
        ) {
            Text(
                text = "Hello ",
                style = MaterialTheme.typography.displayLarge
            )

        }
    }

    @Composable
    fun ColoredSquare(color: Color = Color.DarkGray) {
        Surface(
            color = color, modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        ) {
            Text(text = "Square")
        }
    }

    @Preview
    @Composable
    fun MainScreenPreview(modifier: Modifier = Modifier) {
        MainScreen()
    }

}