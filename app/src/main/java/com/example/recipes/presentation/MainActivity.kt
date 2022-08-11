package com.example.recipes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.recipes.data.network.KtorClientFactory
import com.example.recipes.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val TOKEN = "Token425842458h8418hch5hv1hb9143hv48hb693hb93hbbh"
const val BASE_URL = "https://google.com/api/recipe"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ktorClient = KtorClientFactory().build()
        CoroutineScope(IO).launch {

            val recipe: HttpResponse = ktorClient.get("https://ktor.io/docs/welcome.html")
            println("ktortest: $recipe")

            /*
            val recipeId = 1960
            val recipe = ktorClient.get<RecipeDto>{
                url("$BASE_URL/get?id=$recipeId")
                header("Autorisation", TOKEN)
            }.toRecipe()
            println("Ktor Test: ${recipe}")

             */
        }

        setContent {
            Navigation()

        }
    }
}

