package com.test.melitest.products.models

import com.test.domain.models.products.Installment

data class InstallmentVisualize(
    val quantity: Int,
    val amount: Double,
    val currency_id: String
) {

    constructor(installment: Installment): this(
        installment.quantity, installment.amount, installment.currency_id
    )

    fun showInstallmentInformation(): String {
        return "en $quantity x $amount"
    }
}
