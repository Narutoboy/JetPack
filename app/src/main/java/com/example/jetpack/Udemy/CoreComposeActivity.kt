package com.example.jetpack.Udemy

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**Surface: like CardView/ LinearLayout, surface is container used for background color, elevation, grouping
 * [wrapContentSize] by default Center Align,we can change with Alignment.CenterStart
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
            Surface(color = Color.Green, modifier = Modifier.wrapContentSize(align = Alignment.CenterStart)) {
                Text(
                    text = "Hello Dev",
                    style = MaterialTheme.typography.displayLarge
                )
            }

        }

    }

    @Preview
    @Composable
    fun MainScreenPreview(modifier: Modifier = Modifier) {
        MainScreen()
    }

}