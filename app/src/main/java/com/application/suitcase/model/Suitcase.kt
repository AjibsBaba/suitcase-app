package com.application.suitcase.model

data class Suitcase(
    val name: String,
    val description: String,
    val price: String,
    val quantity: Int,
    val imageURL: String,
    val purchaseStatus: Boolean
)
