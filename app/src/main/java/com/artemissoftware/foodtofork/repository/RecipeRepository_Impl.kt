package com.artemissoftware.foodtofork.repository

import com.artemissoftware.foodtofork.domain.model.Recipe
import com.artemissoftware.foodtofork.network.RecipeApi
import com.artemissoftware.foodtofork.network.model.RecipeDtoMapper

class RecipeRepository_Impl(private val recipeApi: RecipeApi,
                            private val mapper: RecipeDtoMapper): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeApi.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeApi.get(token = token, id))
    }
}