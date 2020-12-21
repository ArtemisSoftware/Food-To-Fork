package com.artemissoftware.foodtofork.di

import com.artemissoftware.foodtofork.network.RecipeApi
import com.artemissoftware.foodtofork.network.model.RecipeDtoMapper
import com.artemissoftware.foodtofork.repository.RecipeRepository
import com.artemissoftware.foodtofork.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(recipeApi: RecipeApi, recipeMapper: RecipeDtoMapper): RecipeRepository{
        return RecipeRepository_Impl(recipeApi = recipeApi, mapper = recipeMapper)
    }
}