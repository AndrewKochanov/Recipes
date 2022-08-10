package com.example.recipes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipes.presentation.recipe_detail.RecipeDetailScreen
import com.example.recipes.presentation.recipe_detail.RecipeDetailViewModel
import com.example.recipes.presentation.recipe_list.RecipeListScreen
import com.example.recipes.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: RecipeListViewModel =  viewModel(navBackStackEntry,"RecipeListViewModel", factory)
            RecipeListScreen(onSelectedRecipe = {recipeId ->
                navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
            })
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: RecipeDetailViewModel =  viewModel(navBackStackEntry,"RecipeDetailViewModel", factory)
            RecipeDetailScreen(recipeId = viewModel.recipeId.value)
        }
    }
}
