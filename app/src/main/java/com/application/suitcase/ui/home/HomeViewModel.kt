package com.application.suitcase.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.application.suitcase.NavigationRoutes
import com.application.suitcase.model.Suitcase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){

    private val auth = FirebaseAuth.getInstance()

    private val _name = MutableStateFlow<String?>(null)
    val name: StateFlow<String?> = _name

    private val _email = MutableStateFlow<String?>(null)
    val email: StateFlow<String?> = _email

    private val _emailVerified = MutableStateFlow<Boolean?>(null)
    val emailVerified: StateFlow<Boolean?> = _emailVerified


    private val _suitcases = MutableStateFlow(listOf<Suitcase>())
    val suitcases: StateFlow<List<Suitcase>> = _suitcases

    init {
        viewModelScope.launch {
            val user = Firebase.auth.currentUser
            user?.let {
                _name.value = it.displayName
                _email.value = it.email
                _emailVerified.value = it.isEmailVerified
            }

            _suitcases.value = listOf(
                Suitcase(
                    name = "Iphone XR",
                    description = "My mobile phone",
                    price = "$340",
                    quantity = 1,
                    imageURL = "",
                    purchaseStatus = false
                )
            )
        }
    }

    fun signOut(navController: NavController) {
        viewModelScope.launch {
            auth.signOut()
            navController.navigate(NavigationRoutes.ONBOARDING_SCREEN)
        }

    }
}