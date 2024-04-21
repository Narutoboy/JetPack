package com.example.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun NotificationScreen() {
    var count =
        rememberSaveable { mutableStateOf(0) }//save for config change, need to serialise custom object
    //stateful compose
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(count.value, { count.value++ })
        MessageBar(count.value)
    }
}

//Mutable State Concept  ;remember(save data in recomposition) or rememberSaveable (save data in config changes)
@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) { //StateLess compose
    //var count = remember { mutableStateOf(0) } //save data in case of recomposition
    Column {
        Text(text = "You have sent ${count} notification")
        Button(onClick = increment) {
            Text(text = "Send Notification")
        }
    }
}

//State Hoisting : Accessing variable declared in parent component within its child components.
//Uni direction flow : data flow (parent - child) top2Bottom, event(button click , child to parent) bottom2Top
@Composable
fun MessageBar(count: Int) {
    Column {
        Row(
            Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                Modifier.padding(8.dp)
            )
            Text(text = "Message sent so far - $count ")
        }
    }
}