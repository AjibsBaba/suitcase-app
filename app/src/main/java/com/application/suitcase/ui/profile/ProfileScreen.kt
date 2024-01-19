package com.application.suitcase.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileScreen() {

    val viewModel: ProfileViewModel = hiltViewModel()

    Scaffold {
            innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}