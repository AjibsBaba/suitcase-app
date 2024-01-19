package com.application.suitcase.ui.suitcase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuitcaseViewModel @Inject constructor(): ViewModel() {
    init {
        viewModelScope.launch{}
    }
}