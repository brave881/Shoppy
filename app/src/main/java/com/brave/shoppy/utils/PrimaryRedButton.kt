package com.brave.shoppy.utils


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R


@Composable
fun PrimaryRedButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .height(mediumCardSize_48)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(),
    ) {

        Box(modifier=Modifier.fillMaxSize(),contentAlignment = Alignment.CenterStart) {
            if (icon != null) {
                Icon(
                    modifier = Modifier.align(Alignment.CenterStart),
                    painter = painterResource(icon),
                    contentDescription = "Google icon",
                )
            }
            Text(modifier=Modifier.align(Alignment.Center),
                text = text,
                fontFamily = FontFamily(Font(R.font.nunito)),
                fontSize = small,
                textAlign = TextAlign.Center
            )
        }
    }
}
