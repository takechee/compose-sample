package com.takechee.composesample.ui.animal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takechee.composesample.data.SampleData
import com.takechee.composesample.domain.Animal
import com.takechee.composesample.ui.theme.ComposeSampleTheme

@Composable
fun AnimalPage(
    animalId: Int,
    upPress: () -> Unit
) {
    val animal = remember(animalId) {
        SampleData.obtainAnimal(id = animalId)
    }
    AnimalPage(animal = animal, upPress = upPress)
}

@Composable
fun AnimalPage(
    animal: Animal,
    upPress: () -> Unit,
) {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            AnimalPageContent(animal = animal, upPress = upPress)
        }
    }
}

@Composable
fun AnimalPageContent(
    animal: Animal,
    upPress: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        item { AnimalPageContentHeader(upPress = upPress) }
        item {
            AnimalPageContentBody(
                animal = animal,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
            )
        }
    }
}

@Composable
fun AnimalPageContentHeader(upPress: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "AppBar")
        },
        navigationIcon = {
            IconButton(onClick = upPress) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun AnimalPageContentBody(animal: Animal, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = animal.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
        )
        Spacer(
            modifier = Modifier.size(width = 0.dp, height = 16.dp)
        )
        Image(
            painter = painterResource(id = animal.imageResId),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val sampleAnimal = SampleData.animals[1]
    ComposeSampleTheme {
        AnimalPageContent(animal = sampleAnimal, upPress = {})
    }
}