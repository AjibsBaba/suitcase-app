package com.application.suitcase.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.application.suitcase.NavigationRoutes
import com.application.suitcase.SuitcaseNavBar
import com.application.suitcase.ui.suitcase.SuitcaseList
import com.application.suitcase.ui.theme.Purple80

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController = rememberNavController(), viewModel: HomeViewModel) {

    val userName = viewModel.name.value
    val suitcases by viewModel.suitcases.collectAsState()


    Scaffold(
        topBar = { TopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .background(Purple80)) {}
            Column {
                Text("Hello $userName", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Welcome back!", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            }
        } },
            ) },
        floatingActionButton = {
            FloatingActionButton(
            onClick = { navController.navigate(NavigationRoutes.SUITCASE_SCREEN) }
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        }, bottomBar = {
            SuitcaseNavBar(index = 0, navController)
        }) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(18.dp)) {
            SuitcaseList(suitcases = suitcases)
        }
    }
}




@Composable
@Preview
fun HomePreview() {
    HomeScreen(viewModel = HomeViewModel())
}
