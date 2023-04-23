package com.test.melitest.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.test.data.products.repositories.ProductRepository
import com.test.domain.usecases.FetchProductsUseCase
import com.test.melitest.products.compose.ProductView
import com.test.melitest.theme.MeliTheme

class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MeliTheme {
                    ProductView(
                        viewModel = ProductsViewModel(FetchProductsUseCase(ProductRepository()))
                    )
                }
            }
        }
    }
}