package com.test.melitest.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.models.products.Product
import com.test.domain.usecases.FetchProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val fetchProductsUseCase: FetchProductsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(ProductScreenState())
    val uiState: LiveData<ProductScreenState> = _uiState

    init {
        fetchProducts("")
    }

    fun fetchProducts(query: String) {
        viewModelScope.launch {
            val products = fetchProductsUseCase.invoke(query)
            _uiState.value = _uiState.value?.copy(products = products)
            /*_uiState.update {
                it.copy(
                    products = products
                )
            }*/
        }
    }
}

data class ProductScreenState(
    val products: List<Product> = emptyList()
)