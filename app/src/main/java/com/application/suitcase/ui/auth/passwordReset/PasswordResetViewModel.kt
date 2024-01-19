package com.application.suitcase.ui.auth.passwordReset

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class PasswordResetViewModel @Inject constructor(): ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _isPasswordReset = mutableStateOf(false)
    val isPasswordReset = _isPasswordReset

    fun resetPassword(email: String) {
        viewModelScope.launch {
            try {
                auth.sendPasswordResetEmail(email).await()
                _isPasswordReset.value = true
            } catch (e: Exception) {
                _isPasswordReset.value = false
            }
        }
    }
}