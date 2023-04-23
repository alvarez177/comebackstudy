package com.test.data.products

import com.test.domain.models.products.Installment

data class ApiProduct(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    val installments: Installment
)
