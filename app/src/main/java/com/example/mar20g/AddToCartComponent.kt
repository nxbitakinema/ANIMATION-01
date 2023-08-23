package com.example.mar20g

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mar20g.ui.theme.MAR20GTheme
import kotlinx.coroutines.delay

@Composable
fun AddToCartComponent(
    pizzaModel: PizzaDataModel,
    transitionAlpha: Float,
    transitionSize: Float,
    onClick: () -> Unit,
) {

    var alpha by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = pizzaModel) {
        delay(200)
        alpha = true
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(transitionSize)
            .alpha(transitionAlpha)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.70f)
                .padding(4.dp)
                .background(shape = RoundedCornerShape(20.dp), color = Color.Black)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Text(
                text = "AMOUNT",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                modifier = Modifier.padding(top = 30.dp)
            )
            Text(
                text = pizzaModel.pizzaPrice,
                fontSize = 20.sp,
                color = Color(0xFFE91E63),
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.heightIn(20.dp))
            AnimatedVisibility(visible = alpha) {
                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription ="check",
                    colorFilter = ColorFilter.tint(Color.Green),
                    modifier = Modifier.size(90.dp)
                )
            }
            Image(
                painter = painterResource(id = pizzaModel.pizzaImage),
                contentDescription ="food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(400.dp)
                    .offset(y = 60.dp)
            )
        }
        Text(
            text = "back to detail",
            color = Color.Gray.copy(alpha = .8f),
            fontWeight = FontWeight.SemiBold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { onClick() }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    MAR20GTheme {
        AddToCartComponent(
            PizzaDataModel.list.first(),
            1f,1f) {  /* clickable parameter */ }
    }
}

