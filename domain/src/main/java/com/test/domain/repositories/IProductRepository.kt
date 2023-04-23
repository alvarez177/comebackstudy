package com.test.domain.repositories

import com.test.domain.models.products.Product

interface IProductRepository {

    suspend fun fetchProducts(query: String): List<Product>
}