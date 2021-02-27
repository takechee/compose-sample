package com.takechee.composesample.data

import com.takechee.composesample.R
import com.takechee.composesample.domain.Animal

object SampleData {
    val animals = listOf(
        Animal(id = 1, name = "Rex", imageResId = R.drawable.dog_akitainu),
        Animal(id = 2, name = "Ruth", imageResId = R.drawable.eto_remake_inu),
        Animal(id = 3, name = "Tucker", imageResId = R.drawable.seiza_koinu),
        Animal(id = 4, name = "Stanley", imageResId = R.drawable.yumekawa_animal_inu),
    )

    fun obtainAnimal(id: Int) = animals.firstOrNull { animal -> animal.id == id } ?: Animal.EMPTY
}