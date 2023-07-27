package com.brave.shoppy.screen.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import com.brave.shoppy.utils.buttons.PrimaryImageButton

class FavouriteScreen : Tab {
    override val options: TabOptions
        @Composable get() {
            val icon = rememberVectorPainter(image = Icons.Default.Favorite)
            return remember {
                TabOptions(
                    index = 2u, icon = icon, title = ""
                )
            }
        }

    @Composable
    override fun Content() {
        FavouriteScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FavouriteScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            var query by remember { mutableStateOf("") }
            var search by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }
            val spacer = MaterialTheme.spacing
            Box(modifier = Modifier.fillMaxSize()) {
                Scaffold(topBar = {
                    SearchBar(
                        query = query,
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
                    val verticalScroll = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),

                        ) {

                            Text(
                                text = "Category",
                                style = MaterialTheme.typography.displayMedium.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                                ),
                                modifier = Modifier.padding(spacer.medium)
                            )
                            LazyRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                contentPadding = PaddingValues(
                                    start = spacer.medium, end = spacer.small
                                ),
                            ) {
                                item {
                                    PrimaryImageButton(
                                        image = R.drawable.image_1, onClick = {}, isImage = false
                                    )
                                }
                                item {
                                    PrimaryImageButton(image = R.drawable.image_1, onClick = {})

                                }
                                item {
                                    PrimaryImageButton(image = R.drawable.pants, onClick = {})

                                }
                                item {
                                    PrimaryImageButton(image = R.drawable.image_2, onClick = {})
                                }
                                item {
                                    PrimaryImageButton(image = R.drawable.hat, onClick = {})

                                }
                                item {
                                    PrimaryImageButton(image = R.drawable.watch, onClick = {})
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

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
                            val state = rememberLazyGridState()

                            LazyVerticalGrid(
                                verticalArrangement = Arrangement.spacedBy(spacer.small),
                                horizontalArrangement = Arrangement.spacedBy(spacer.small),
                                modifier = Modifier.padding(),
                                state = state,
                                columns = GridCells.Adaptive(150.dp),
                                contentPadding = PaddingValues(
                                    start = spacer.medium, end = spacer.medium
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
    }

    @Preview
    @Composable
    fun FavouriteScreenContentPreview() {
        ShoppyTheme() {
            FavouriteScreenContent()
        }
    }
}
