package com.brave.shoppy.screen.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.ui.theme.filterBackgroundColor
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.ItemReview
import com.brave.shoppy.utils.buttons.PrimaryImageButton
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.largeVerticalPadding_24
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallPadding_10

class SearchScreen : AppScreen() {
    @Composable
    override fun Content() {
        SearchScreenContent()
    }


    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalLayoutApi::class,
        ExperimentalFoundationApi::class
    )
    @Composable
    fun SearchScreenContent() {

        var search by remember { mutableStateOf("") }
        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        var filterDialogState by remember { mutableStateOf(false) }

        if (filterDialogState){


        }

        Scaffold(topBar = {
            CenterAlignedTopAppBar(modifier = Modifier.padding(start = largeHorizontalPadding_24),
                navigationIcon = {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
//                            onEvent.invoke(SettingsScreenEvent.Back)
                        })
                },
                title = {
                    Text(text = stringResource(R.string.shipment))
                })
        }) { paddingValues ->
            Column(
                Modifier
                    .padding(top = paddingValues.calculateTopPadding())
                    .fillMaxSize()
            ) {
                Box(
                    Modifier
                        .padding(horizontal = largeHorizontalPadding_24)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(259.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterStart)
                    ) {
                        SearchBar(
                            query = query,
                            onQueryChange = { query = it },
                            onSearch = { search = it },
                            active = false,
                            onActiveChange = { active = it },
                            placeholder = { Text(text = "Write here") },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    contentDescription = "Search icon"
                                )
                            },
                            shape = RoundedCornerShape(mediumCornerShape_10),
                            colors = SearchBarDefaults.colors(
                                containerColor = primaryTextFieldBackground,
                                dividerColor = Color.Unspecified
                            )
                        ) {}
                    }
                    PrimaryImageButton(modifier = Modifier.align(Alignment.CenterEnd),
                        image = R.drawable.settings,
                        backgroundColor = filterBackgroundColor,
                        onClick = { filterDialogState = true })
                }

                if (query.isBlank()) {
                    Column(
                        Modifier
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = largeHorizontalPadding_24
                            )
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.last_search),
                            style = MaterialTheme.typography.displaySmall
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(primaryPadding)
                        )
                        FlowRow(
                            Modifier
                                .padding(bottom = largeVerticalPadding_24)
                                .fillMaxWidth(),
                        ) {
                            for (i in 1..6) {
                                Button(modifier = Modifier.padding(end = smallPadding_10),
                                    shape = RoundedCornerShape(mediumCornerShape_10),
                                    onClick = {

                                    }) {
                                    Text(text = "Kick Denim")
                                }
                            }
                        }

                        Text(
                            text = stringResource(R.string.best_seller),
                            style = MaterialTheme.typography.displaySmall
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(primaryPadding)
                        )
                        LazyRow {
                            items(count = 5) {
                                ItemReview(modifier = Modifier.padding(end = smallPadding_10),
                                    image = R.drawable.placeholder,
                                    name = "Acapella Black Shirt",
                                    price = "$240",
                                    deprecatedPrice = "$350",
                                    onClickImage = { /*TODO*/ }) {

                                }
                            }
                        }
                    }
                } else {
                    if (false) {                                   /// this line will change
                        LazyVerticalStaggeredGrid(
                            modifier = Modifier
                                .padding(
                                    start = largeHorizontalPadding_24, top = largeVerticalPadding_24
                                )
                                .fillMaxSize(), columns = StaggeredGridCells.Fixed(2)
                        ) {
                            item {
                                Text(
                                    modifier = Modifier.padding(
                                        end = largeHorizontalPadding_24,
                                        bottom = largeVerticalPadding_24
                                    ),
                                    text = "${5} ${stringResource(R.string.results_found_for_you)}",
                                    style = MaterialTheme.typography.displayLarge
                                )
                            }
                            items(count = 10) {
                                ItemReview(modifier = Modifier.padding(
                                    end = largeHorizontalPadding_24,
                                    bottom = largeVerticalPadding_24
                                ),
                                    image = R.drawable.placeholder,
                                    name = "Acapella Black Shirt",
                                    price = "$240",
                                    deprecatedPrice = "$350",
                                    onClickImage = { /*TODO*/ }) {

                                }
                            }
                        }
                    } else {
                        Column(
                            Modifier
                                .padding(largeHorizontalPadding_24)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "${stringResource(R.string.cannot_find)} ${"8"}",
                                style = MaterialTheme.typography.displayMedium
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = largeHorizontalPadding_24),
                                text = stringResource(R.string.try_searching_again_with_a_different_spelling_or_keyword),
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
