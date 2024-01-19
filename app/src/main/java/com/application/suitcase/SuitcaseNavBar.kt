package com.application.suitcase

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun SuitcaseNavBar(index: Int = 0, navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(index) }
    val items = listOf("Suitcases", "Purchased", "Profile")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.ShoppingCart, Icons.Filled.Person)
    val routes = listOf(NavigationRoutes.HOME_SCREEN, NavigationRoutes.PURCHASED_SCREEN, NavigationRoutes.PROFILE_SCREEN)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    NavigateTo(navController = navController, routes[index])
                }
            )


        }
    }
}

private fun NavigateTo(navController: NavController, route: String) {
    navController.navigate(route)
}