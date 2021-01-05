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

    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)

    var categoryScrollPosition: Float = 0f


    init{
        newSearch()

    }

    fun newSearch(){
        viewModelScope.launch {
            val result = repository.search(token = token, page = 1, query = query.value)
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String){
        this.query.value = query
    }


    fun onSelectedCategoryChanged(category: String){
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onChangeCategoryScrollPosition(position: Float){
        this.categoryScrollPosition = position
    }
}