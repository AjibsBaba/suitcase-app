package com.application.suitcase.ui.auth.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.application.suitcase.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController = rememberNavController(), viewModel: RegistrationViewModel) {

    var emailAddress by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }


    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }, navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() },
                    colors = IconButtonDefaults.outlinedIconButtonColors(contentColor = Color.Black))
                     {
                        Icons.Default.ArrowBack
                    }
            })
        },
    ) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(20.dp)
            .fillMaxSize()) {
            Text("Create Account", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Setup an account to start using suitcase today", fontWeight = FontWeight.Normal)
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                OutlinedTextField(value = emailAddress, onValueChange = { emailAddress = it},
                    label = { Text("Email Address") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = password, onValueChange = { password = it},
                    label = { Text("Password") }, singleLine = true, modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Button(onClick = {
                             viewModel.signUp(navController, emailAddress.trim(), password.trim())
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp)
                .height(52.dp) ) {
                Text("Create my account")
            }
        }
    }
}


@Composable
@Preview
fun RegistrationScreenPreview() {
    RegistrationScreen(viewModel = RegistrationViewModel())
}