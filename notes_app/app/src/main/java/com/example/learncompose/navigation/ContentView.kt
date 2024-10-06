package com.example.learncompose.navigation

import androidx.annotation.ContentView
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.MyApp
import com.example.learncompose.ui.form.createNotes
import com.example.learncompose.viewmodel.NotesViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

@Composable
fun Navigation() {
    val navController = rememberNavController();
    val viewModel: NotesViewModel = remember { NotesViewModel() }

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route){
            MyApp(navController, viewModel)
        }

        composable(NavigationItem.CreateForm.route){
            createNotes(navController, viewModel = viewModel,null)
        }
    }

}