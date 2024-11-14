package com.example.jetpackcomposeprac

import android.app.Service
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.security.Provider
import java.util.Stack


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var  s = List
        enableEdgeToEdge()
        var service: Service
        setContent {
            JetpackComposePracTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .systemBarsPadding()
                    .statusBarsPadding()
                    .background(Color.Green),
                    topBar = {
                        TopAppBar(
                           title =  { Text(text = "Collapsible Toolbar") },
                            navigationIcon = {
                                IconButton(onClick = { /* Handle navigation */ }) {
                                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                                }
                            }
                        )
                    }){ paddingValues ->
                    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                        Log.d("==padding===$paddingValues", "===")
                        mainScreen()
                    }
                }
            }
        }
    }
}



@Composable
fun  mainScreen(){
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home"){ HomeScreen {
            Log.d("navigationController","backQueueSize========${navController.backQueue.size}")
            navController.navigate("details") }
        }
        composable("details"){DetailScreen(navController)}
    }
}

@Composable
fun DetailScreen(navController: NavHostController) {
    Text("Details Screen")
}

@Composable
fun HomeScreen(callback:()->Unit) {
    Column {
        Text("Home Screen")
        Button(onClick = {callback()}) {
            Text("Go to Details")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePracTheme {
        Greeting("Android")
    }
}