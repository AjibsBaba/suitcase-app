package com.application.suitcase.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.suitcase.model.Suitcase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){

    private val _name = MutableStateFlow<String?>(null)
    val name: StateFlow<String?> = _name

    private val _suitcases = MutableStateFlow(listOf<Suitcase>())
    val suitcases: StateFlow<List<Suitcase>> = _suitcases

    init {
        viewModelScope.launch {
            val user = Firebase.auth.currentUser
            user?.let {
                _name.value = it.displayName
                val email = it.email
                val emailVerified = it.isEmailVerified
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
}