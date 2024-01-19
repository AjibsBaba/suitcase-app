package com.application.suitcase.ui.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.application.suitcase.NavigationRoutes
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){
    private val auth = FirebaseAuth.getInstance()


    // Track Authentication Status
    private val _isAuthenticated = MutableStateFlow(false)

    fun signIn(navController: NavController, email: String, password: String) {
        viewModelScope.launch {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        task ->
                        if (task.isSuccessful) {
                            Log.d("Auth", "signInWithEmail:success")
                            navController.navigate(NavigationRoutes.HOME_SCREEN)
                        } else {
                            Log.w("Auth", "signInWithEmail:failure", task.exception)
                        }
                    }

        }
    }

    fun checkAuthenticationStatus() {
        _isAuthenticated.value = auth.currentUser != null
    }

    fun signOut() {
        auth.signOut()
        _isAuthenticated.value = false
    }

}