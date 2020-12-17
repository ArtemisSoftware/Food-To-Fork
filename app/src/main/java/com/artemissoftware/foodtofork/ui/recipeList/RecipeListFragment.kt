package com.artemissoftware.foodtofork.ui.recipeList

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment(){

    val viewModel: RecipeListViewModel by viewModels()

    //To share the same viewmodel between fragments
    //val viewModel: RecipeListViewModel by activityViewModels()
}