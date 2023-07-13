package com.brave.shoppy.screen.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.comment.components.CommentItem
import com.brave.shoppy.screen.settings.SettingsScreenEvent
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.textFields.SecondaryTextField

class CommentScreen : AppScreen() {

    @Composable
    override fun Content() {
        CommentScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CommentScreenContent() {

        var commentText by remember { mutableStateOf("") }

        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(start = largeHorizontalPadding_24),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
//                            onEvent.invoke(SettingsScreenEvent.Back)
                        })
                },
                title = {
                    Text(text = stringResource(R.string.comment))
                })
        }) { paddingValues ->
            Box(
                Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = bottomPadding_20,
                        start = largeHorizontalPadding_24,
                        end = largeHorizontalPadding_24
                    )
                    .fillMaxSize()
            ) {
                LazyColumn {
                    items(count = 10) {
                        CommentItem(
                            image = R.drawable.placeholder,
                            name = "Kity Kate",
                            isMyMessage = true,
                            comment = "good item, okay quality, it's just that there is a little defect in the item"
                        )
                    }
                }
                Box(
                    Modifier.fillMaxWidth().background(Color.White).align(Alignment.BottomCenter),
                    contentAlignment = Alignment.Center
                ) {
                    SecondaryTextField(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = commentText,
                        placeHolder = stringResource(R.string.write_here),
                        onValueChange = { commentText = it },
                        icon = R.drawable.thumbsup,
                        onCLick = {

                        }
                    )
                    Card(
                        modifier = Modifier
                            .size(mediumCardSize_48)
                            .align(Alignment.CenterEnd),
                        shape = RoundedCornerShape(mediumCornerShape_10),
                        onClick = {

                        },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.plane),
                                contentDescription = "send"
                            )
                        }
                    }
                }
            }
        }
    }
}
