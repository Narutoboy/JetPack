package com.example.jetpack.Udemy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.R

class ProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Surface(color = Color.Yellow) {
            ProfileCard()
        }
    }

    @Composable
    fun ProfileCard(modifier: Modifier = Modifier) {

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(modifier = Modifier.wrapContentSize()) {
                ProfileImage()
                ProfileContent()

            }

        }
    }

    private @Composable
    fun ProfileImage() {
        Card(
            shape = CircleShape,
            border = BorderStroke(
                width = 2.dp, color = Color.Yellow,
            ),
            modifier = Modifier.padding(16.dp),

            ) {
            Image(
                painter = painterResource(R.drawable.naruto_pic),
                contentDescription = "Image",
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Crop
            )
        }


    }

    private @Composable
    fun ProfileContent() {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Naruto Boy",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "No 1 hyper active knuckle head night",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.alpha(0.6f)
            )
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview(modifier: Modifier = Modifier) {
        MainScreen()
    }
}