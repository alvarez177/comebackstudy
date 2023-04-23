package com.test.melitest.products.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.melitest.R
import com.test.melitest.products.ProductsViewModel
import com.test.melitest.products.models.ProductVisualize
import com.test.melitest.theme.NormalYellow

@Preview(showBackground = true)
@Composable
fun ProductView(viewModel: ProductsViewModel) {
    val uiState = viewModel.uiState.observeAsState()
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        paddingValues
        LazyColumn {
            items(items = uiState.value?.products ?: emptyList()) {
                ProductItemView(
                    productVisualize = ProductVisualize(it)
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        modifier =
        Modifier.wrapContentSize(),
        title = {
            Row() {
                SearchTextField(text = "", onTextChanged = {})
            }
        },
        backgroundColor = NormalYellow,
        contentColor = Color.White
    )
}


@Composable
private fun SearchTextField(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    val textState = remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)) {
        OutlinedTextField(
            modifier = Modifier
                .height(60.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(30.dp),
            value = textState.value,
            onValueChange = onTextChanged,
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            placeholder = {
                Text(text = "Buscar en Mercado Libre",
                fontSize = 15.sp)
            },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_search)
                    , contentDescription = "")
            }
        )
    }
}