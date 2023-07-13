package com.brave.shoppy.utils.textFields

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.largeCardSize_78
import com.brave.shoppy.utils.mediumCornerShape_10

@Composable
fun SecondaryTextField(
    modifier:Modifier=Modifier,
    text: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    onCLick: () -> Unit,
    icon: Int,
) {
    TextField(
        modifier = modifier
            .padding(end = largeCardSize_78)
            .fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeHolder) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = primaryTextFieldBackground,
            unfocusedContainerColor = primaryTextFieldBackground,
            disabledContainerColor = primaryTextFieldBackground,
            focusedIndicatorColor = Color.Unspecified,
            unfocusedIndicatorColor = Color.Unspecified,
            errorContainerColor = Color.Red,
            errorIndicatorColor = Color.Red
        ),
        trailingIcon = {
            Image(
                modifier = Modifier.clickable { onCLick() },
                painter = painterResource(id = icon),
                contentDescription = "icon"
            )
        },
        shape = RoundedCornerShape(mediumCornerShape_10),
    )
}