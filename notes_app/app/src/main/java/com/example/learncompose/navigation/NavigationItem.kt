package com.example.learncompose.navigation


    sealed class NavigationItem(val route: String) {
        object Home : NavigationItem(Route.MyApp.name)
        object CreateForm : NavigationItem(Route.CreateNote.name)
    }
