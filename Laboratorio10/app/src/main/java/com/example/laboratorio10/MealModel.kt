package com.example.laboratorio10

data class MealResponse(val meals: List<Meal>)
data class Meal(
    val name: String,
    val instructions: String,
    val image: String
)