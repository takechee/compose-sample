package com.takechee.composesample.domain

import androidx.annotation.DrawableRes

data class Animal(
    val id: Int,
    val name: String,
    @DrawableRes val imageResId: Int,
)
