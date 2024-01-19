package com.application.suitcase.ui.auth.register

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.application.suitcase.NavigationRoutes
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(): ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _isUserRegistered = mutableStateOf(false)
    val isRegistered = _isUserRegistered

    fun signUp(navController: NavController, email: String, password: String) {
        viewModelScope.launch {
            try {
                val result = auth.createUserWithEmailAndPassword(email, password)
                _isUserRegistered.value = true

                if (result.isSuccessful) {
                    navController.navigate(NavigationRoutes.LOGIN_SCREEN)
                    Log.d("Registration Status", result.toString())
                }
            } catch (e: Exception) {
                _isUserRegistered.value = false
            }
        }
    }
}