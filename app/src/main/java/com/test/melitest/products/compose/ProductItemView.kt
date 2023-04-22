package com.test.melitest.products.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.melitest.theme.MeliTypography
import com.test.melitest.R
import com.test.melitest.theme.Green

@Preview(showBackground = true)
@Composable
fun ProductItemView() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .clickable{ },
        elevation = 10.dp) {
        Row(
            modifier = Modifier.wrapContentSize()
        ) {
            LeftSide()
            RightSide()
        }
    }
}

@Composable
private fun LeftSide() {
    Image(
        painter = painterResource(id = R.mipmap.testimage),
        contentDescription = ""
    )
    /*AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = ""
    )*/
}

@Composable
private fun RightSide() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Moto G6 plus 64 GB indigo oscuro 4GB RAM",
            style = MeliTypography.h6.copy(fontWeight = FontWeight.Normal)
        )
        Text(
            text = "$ 569.000",
            style = MeliTypography.subtitle1
        )
        Text(
            text = "En 36 x $ 15.830",
            style = MeliTypography.caption.copy(fontSize = 8.sp)
        )
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        Text(
            text = "Envío gratis",
            style = TextStyle(
                color = Green,
                fontSize = 9.sp,
                fontFamily = FontFamily.Default
            )
        )
    }
}