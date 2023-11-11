package com.example.laboratorio10

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreRepository() {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getCategories(): MutableList<Categories> {
        val categories = db.collection("Categories").get().await()
        val allCategories = mutableListOf<Categories>()


        for (category in categories) {
            allCategories.add(
                Categories(
                    name = category.getString("name")!!,
                    image = category.getString("image")!!
                )
            )
        }

        return allCategories
    }

    suspend fun getRecipeList(category: String): MutableList<Meal>{
        val recipes = db.collection("Categories").document(category).collection("Recipes").get().await()
        val allRecipes = mutableListOf<Meal>()
        for (recipe in recipes) {
            allRecipes.add(
                Meal(
                    name = recipe.getString("name")!!,
                    instructions = recipe.getString("instructions")!!,
                    image = recipe.getString("image")!!
                )
            )
        }
        return allRecipes
    }

    suspend fun getRecipeDetail(category: String, recipe: String): Meal{
        val recipeDetail = db.collection("Categories").document(category).collection("Recipes").document(recipe).get().await()
        return Meal(
            name = recipeDetail.getString("name")!!,
            instructions = recipeDetail.getString("instructions")!!,
            image = recipeDetail.getString("image")!!
        )
    }

    }

