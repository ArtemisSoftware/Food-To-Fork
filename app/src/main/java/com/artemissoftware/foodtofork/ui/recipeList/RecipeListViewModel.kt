package com.artemissoftware.foodtofork.ui.recipeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.foodtofork.domain.model.Recipe
import com.artemissoftware.foodtofork.repository.RecipeRepository
import kotlinx.coroutines.launch
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(private val repository: RecipeRepository,
                                                       private @Named("auth_token") val token: String) : ViewModel(){


    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query: MutableState<String> = mutableStateOf("")

    init{
        newSearch(query.value)

    }

    fun newSearch(query: String){
        viewModelScope.launch {
            val result = repository.search(token = token, page = 1, query = query)
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
    }

}