package com.application.suitcase.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.application.suitcase.SuitcaseNavBar
import com.application.suitcase.ui.home.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, viewModel: HomeViewModel) {

    val email = viewModel.email.value
    val emailVerified = viewModel.emailVerified.value

    Scaffold(
        topBar = { TopAppBar(title = { Text("Purchased Suitcases")}) },
        bottomBar = {
            SuitcaseNavBar(index = 1, navController)
        },
    ) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text("Email: $email")
            Text("Verification Status: $emailVerified")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { viewModel.signOut(navController) }, modifier = Modifier.fillMaxWidth()) {
                Text("Sign Out")
            }
        }
    }
}