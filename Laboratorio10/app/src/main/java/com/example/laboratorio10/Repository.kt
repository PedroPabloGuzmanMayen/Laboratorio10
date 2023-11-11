package com.example.laboratorio10

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreRepository(private val collectionName: String) {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getCategories(): MutableList<Categories> {
        val categories = db.collection("Categories")
        val allCategories = mutableListOf<Categories>()
        val query = categories.get().await()

        for (category in query) {
            allCategories.add(
                Categories(
                    name = category.getString("name")!!,
                    image = category.getString("image")!!
                )
            )
        }

        return allCategories
    }
}
