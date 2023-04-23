package com.test.domain.models.products

data class Installment(
    val quantity: Int,
    val amount: Double,
    val currency_id: String
)
