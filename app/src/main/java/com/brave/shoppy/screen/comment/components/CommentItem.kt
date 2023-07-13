package com.brave.shoppy.screen.comment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.card.ImageCard
import com.brave.shoppy.utils.largeCornerShape_15
import com.brave.shoppy.utils.largeIconSize_32
import com.brave.shoppy.utils.primaryPadding

@Composable
fun CommentItem(
    image: Int,
    name: String,
    comment: String,
    isMyMessage: Boolean = false
) {

    Column(
        Modifier
            .padding(bottom = bottomPadding_20)
            .fillMaxWidth(),
        horizontalAlignment = if (isMyMessage) Alignment.End else Alignment.Start
    ) {
        Row {
            ImageCard(
                modifier = Modifier.padding(end = primaryPadding).size(largeIconSize_32),
                image = image,
                shape = RoundedCornerShape(largeCornerShape_15)
            )
            CommentTextCard(title = name, text = comment,isMyMessage)
        }
    }
}