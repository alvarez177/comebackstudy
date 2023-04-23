package com.test.domain.models.products

data class Product(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    val installments: Installment
)
