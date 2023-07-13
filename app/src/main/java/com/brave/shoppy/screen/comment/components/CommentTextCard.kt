package com.brave.shoppy.screen.comment.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.dialogBackgroundColor
import com.brave.shoppy.ui.theme.myCommentTextStyle_14
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.ui.theme.styleCargoName_16
import com.brave.shoppy.utils.betweenTextPadding
import com.brave.shoppy.utils.horizontalPadding_12
import com.brave.shoppy.utils.largeCornerShape_15
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.verticalPadding_12

@Composable
fun CommentTextCard(
    title: String,
    text: String,
    isMyMessage: Boolean = false
) {
    Card(
        shape = RoundedCornerShape(largeCornerShape_15),
        colors = CardDefaults.cardColors(containerColor = if (isMyMessage) MaterialTheme.colorScheme.primary else primaryTextFieldBackground)
    ) {
        Text(
            modifier = Modifier.padding(
                start = primaryPadding,
                end = primaryPadding,
                top = primaryPadding,
                bottom = betweenTextPadding
            ),
            text = title,
            style =
            if (isMyMessage) styleCargoName_16 else MaterialTheme.typography.headlineMedium.copy(
                fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
            )
        )
        Text(
            modifier = Modifier.padding(
                start = primaryPadding,
                end = primaryPadding,
                bottom = primaryPadding
            ),
            text = text,
            style = if (isMyMessage) myCommentTextStyle_14 else MaterialTheme.typography.headlineMedium
        )
    }
}
