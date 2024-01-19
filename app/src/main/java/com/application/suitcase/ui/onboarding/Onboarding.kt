package com.application.suitcase.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.application.suitcase.NavigationRoutes
import com.application.suitcase.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(navController: NavController = rememberNavController()) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(stringResource(id = R.string.app_name))})
    }) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(28.dp)
                .fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp) ,modifier = Modifier.padding(bottom = 48.dp)) {
                Text(text = "Manage your suitcases", style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp, fontWeight = FontWeight.Bold))
                Text(text = "Add your suitcase information and manage your data on the go", style = TextStyle(textAlign = TextAlign.Center, fontSize = 14.sp, fontWeight = FontWeight.Normal))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { navController.navigate(NavigationRoutes.LOGIN_SCREEN) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Login")
                }
                TextButton(onClick = { navController.navigate(NavigationRoutes.REGISTRATION_SCREEN)}, contentPadding = PaddingValues.Absolute(0.dp)) {
                    Text("Don't have an account? Sign Up")
                }

            }
        }
    }
}


@Composable
@Preview
fun OnboardingPreview() {
    OnboardingScreen()
}