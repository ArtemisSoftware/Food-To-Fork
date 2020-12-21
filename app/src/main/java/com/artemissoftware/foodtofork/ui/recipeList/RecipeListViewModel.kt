package com.artemissoftware.foodtofork.ui.recipeList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.artemissoftware.foodtofork.repository.RecipeRepository
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(private val repository: RecipeRepository,
                                                       private @Named("auth_token") val token: String) : ViewModel(){
}