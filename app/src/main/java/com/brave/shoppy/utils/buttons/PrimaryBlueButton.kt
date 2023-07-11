package com.brave.shoppy.utils.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.small

@Composable
fun PrimaryBlueButton(
    modifier: Modifier = Modifier,
    text: String,
    isCanConfirm: Boolean = true,
    icon: Int? = null,
    onSelected: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        enabled = isCanConfirm,
        modifier = modifier
            .height(mediumCardSize_48)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (onSelected) MaterialTheme.colorScheme.primary else Color.Gray
        ),
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
            if (icon != null) {
                Icon(
                    modifier = Modifier.align(Alignment.CenterStart),
                    painter = painterResource(icon),
                    contentDescription = "",
                )
            }
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                fontFamily = FontFamily(Font(R.font.nunito)),
                fontSize = small,
                textAlign = TextAlign.Center
            )
        }
    }
}
