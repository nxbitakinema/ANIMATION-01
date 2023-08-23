package com.example.mar20g

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mar20g.ui.theme.MAR20GTheme

@Composable
fun ProductCarousel(
    pizzaModel: PizzaDataModel, pageOffset: Float
) {
    Column(
        modifier = Modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = pizzaModel.pizzaImage),
            contentDescription = "pizza",
            modifier = Modifier
                .size(240.dp)
                .shadow(8.dp, shape = CircleShape, spotColor = Color(0xFFE91E63)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(52.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = pizzaModel.pizzaName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pizzaModel.pizzaPrice,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFE91E63).copy(alpha = 0.7f),
                // modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview_ProductCarouselItem() {
    MAR20GTheme {
        ProductCarousel(PizzaDataModel.list.first(), 1f)
    }
}