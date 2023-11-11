package com.example.laboratorio10

data class CategoriesResponse(val categories: List<Categories>)

data class Categories(
    val name: String,
    val image: String)