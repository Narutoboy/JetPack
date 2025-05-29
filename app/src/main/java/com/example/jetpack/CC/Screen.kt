package com.example.jetpack.CC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.R

@Preview(heightDp = 500)
@Composable
fun previewItem(modifier: Modifier = Modifier) {
    /*blogCategory(
        img = R.drawable.ic_launcher_foreground,
        title = "Programming",
        subTitle = "Learn different language"
    )*/
    /*
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map{item->
            blogCategory(img = item.ima, title = item.title, subTitle =item.subTitle)
        }
    }*/
    LazyColumn(content = {
        items(getCategoryList()) { item ->
            blogCategory(img = item.ima, title = item.title, subTitle = item.subTitle)
        }
    })
}

@Composable
fun blogCategory(img: Int, title: String, subTitle: String, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "Image",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            itemDescription(title, subTitle, Modifier.weight(0.8F))
        }
    }
}

@Composable
private fun itemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val ima: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_launcher_foreground, "kotlin", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Java", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "git", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "xml", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "gradle", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "CI/CD", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "kotlin", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Java", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "git", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "xml", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "gradle", "new Language"))
    list.add(Category(R.drawable.ic_launcher_foreground, "CI/CD", "new Language"))
    return list
}