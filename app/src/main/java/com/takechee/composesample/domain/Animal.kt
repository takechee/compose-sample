package com.takechee.composesample.domain

import androidx.annotation.DrawableRes

data class Animal(
    val id: Int,
    val name: String,
    @DrawableRes val imageResId: Int,
) {
    fun isEmpty() = this == EMPTY

    companion object {
        val EMPTY = Animal(
            id = 0,
            name = "",
            imageResId = 0,
        )
    }
}