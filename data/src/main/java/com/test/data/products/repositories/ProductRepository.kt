package com.test.data.products.repositories

import com.test.domain.models.products.Installment
import com.test.domain.models.products.Product
import com.test.domain.repositories.IProductRepository

class ProductRepository : IProductRepository {

    override suspend fun fetchProducts(query: String): List<Product> {
        val installment1 = Installment(
            quantity = 36,
            amount = 15.830,
            currency_id = "COP"
        )

        val product1 = Product(
            id = "1CC4F",
            title = "Moto G6 plus 64 GB indigo oscuro 4GB RAM",
            thumbnail = "http://http2.mlstatic.com/D_869139-MCO47557566663_092021-I.jpg",
            price = 569.000,
            installments = installment1
        )

        val installment2 = Installment(
            quantity = 36,
            amount = 45.830,
            currency_id = "COP"
        )

        val product2 = Product(
            id = "1CC4A",
            title = "Portatil Asus Gamer",
            thumbnail = "http://http2.mlstatic.com/D_869139-MCO47557566663_092021-I.jpg",
            price = 3000.000,
            installments = installment2
        )
        return listOf(product1, product2)
    }
}