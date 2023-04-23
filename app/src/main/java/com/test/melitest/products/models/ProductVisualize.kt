package com.test.melitest.products.models

import com.test.domain.models.products.Product

data class ProductVisualize(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    val installments: InstallmentVisualize
) {

    constructor(product: Product) : this(
        product.id,
        product.title,
        product.thumbnail,
        product.price,
        InstallmentVisualize(product.installments)
    )

    fun showPrice(): String {
        return "$ $price"
    }

    fun showInstallmentInformation(): String {
        return installments.showInstallmentInformation()
    }
}
