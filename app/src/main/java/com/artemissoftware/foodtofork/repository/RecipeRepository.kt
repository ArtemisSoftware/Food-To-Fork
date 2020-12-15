package com.artemissoftware.foodtofork.repository

import com.artemissoftware.foodtofork.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}