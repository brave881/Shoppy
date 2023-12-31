package com.brave.shoppy.utils.textFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.horizontalPadding_12
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.verticalPadding_12

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTextField(
    modifier: Modifier = Modifier,
    text: String,
    title: String,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(mediumCornerShape_10),
        colors = CardDefaults.cardColors(containerColor = primaryTextFieldBackground)
    ) {
        Text(
            modifier = Modifier.padding(
                start = horizontalPadding_12, top = verticalPadding_12
            ), text = title, style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
            )
        )
        TextField(
            value = text,
            onValueChange = onTextChange,
            singleLine = true,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = primaryTextFieldBackground,
                unfocusedContainerColor = primaryTextFieldBackground,
                disabledContainerColor = primaryTextFieldBackground,
                focusedIndicatorColor = Color.Unspecified,
                unfocusedIndicatorColor = Color.Unspecified,
                errorContainerColor = Color.Red,
                errorIndicatorColor = Color.Red
            ),
            placeholder = placeholder,
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
