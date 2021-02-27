package com.takechee.composesample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takechee.composesample.data.SampleDataFactory
import com.takechee.composesample.domain.Animal
import com.takechee.composesample.ui.theme.ComposeSampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ScreenContent()
                }
            }
        }
    }
}

@Composable
fun AnimalListItem(animal: Animal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Image(
            painter = painterResource(id = animal.imageResId),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 4.dp)
                .size(24.dp)
                .align(Alignment.CenterVertically)
        )
        Spacer(
            modifier = Modifier.width(width = 16.dp)
        )
        Text(
            text = animal.name,
            modifier = Modifier.weight(weight = 1f)
        )
    }
}

@Composable
fun AnimalList(animals: List<Animal>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = animals) { animal ->
            AnimalListItem(animal = animal)
            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun ScreenContent() {
    val animals = SampleDataFactory.createAnimals()
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Row {
                        Text(text = "AppBar")
                        Text(text = " With another child")
                    }
                }
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                AnimalList(animals = animals, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        ScreenContent()
    }
}