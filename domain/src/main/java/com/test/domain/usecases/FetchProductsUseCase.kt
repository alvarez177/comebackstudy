package com.test.domain.usecases

import com.test.domain.models.products.Product
import com.test.domain.repositories.IProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FetchProductsUseCase(
    private val productRepository: IProductRepository
) {

    suspend operator fun invoke(query: String): List<Product> {
        return withContext(Dispatchers.IO) {
            delay(2000)
            val response = productRepository.fetchProducts(query)
            val a = ""
            response
        }
    }
}