package com.brave.shoppy.screen.sign_in.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.brave.shoppy.utils.signInButtonHeight
import com.brave.shoppy.utils.signInButtonWidth
import com.brave.shoppy.utils.small


@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .width(signInButtonWidth)
            .height(signInButtonHeight),
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                painter = painterResource(icon),
                contentDescription = "Google icon",
            )
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.nunito)),
                fontSize = small,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(20.dp))
        }

    }
}
