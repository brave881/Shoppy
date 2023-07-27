package com.brave.shoppy.screen.bag

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.ItemReview
import com.brave.shoppy.utils.largeVerticalPadding_24
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.smallPadding_10

class BagScreen : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(image = Icons.Default.ShoppingCart)
            return remember {
                TabOptions(
                    index = 1u, title = "", icon
                )
            }
        }

    @Composable
    override fun Content() {
        BagScreenContent()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    @Composable
    fun BagScreenContent() {
        var query by remember { mutableStateOf("") }
        var search by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        val spacer = MaterialTheme.spacing
        Box(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                SearchBar(query = query,
                    onQueryChange = { query = it },
                    onSearch = { search = it },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text(text = "Write here") },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            contentDescription = "Search icon"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacer.medium)
                ) {}
            }) {
                Column(modifier = Modifier.fillMaxSize().padding(it)) {
                    Text(
                        text = "Package status",
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        ),
                        modifier = Modifier.padding(
                            top = spacer.medium,
                            start = spacer.medium,
                        )
                    )
                    FlowRow(
                        Modifier
                            .padding(
                               spacer.medium
                            )
                            .fillMaxWidth(),
                    ) {
                        for (i in 1..4) {
                            Button(modifier = Modifier.padding(end = smallPadding_10),
                                shape = RoundedCornerShape(mediumCornerShape_10),
                                onClick = { }) {
                                Text(text = "Packaged")
                            }
                        }
                    }

                    Text(
                        text = "Your Items",
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        ),
                        modifier = Modifier.padding(spacer.medium)
                    )

                    val name = listOf(
                        "Acapella Black Shirt",
                        "Acapella Black Shirt",
                        "Acapella Black Shirt",
                        "Acapella Black Shirt",
                        "Acapella Black Shirt",
                    )

                    val price = listOf(
                        "240$",
                        "240$",
                        "240$",
                        "240$",
                        "240$",
                    )
                    val deprecatedPrice = listOf(
                        "480$",
                        "480$",
                        "480$",
                        "480$",
                        "480$",
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier,
                        contentPadding = PaddingValues(
                            start = spacer.medium,
                            end = spacer.medium,
                        )
                    ) {
                        items(5) { index ->
                            ItemReview(image = R.drawable.placeholder,
                                name = name[index],
                                price = price[index],
                                deprecatedPrice = deprecatedPrice[index],
                                onClickImage = {}) {}
                        }
                    }


                }
            }


        }
    }

    @Preview
    @Composable
    fun BagScreenContentPreview() {
        ShoppyTheme() {
            BagScreenContent()
        }
    }

}
