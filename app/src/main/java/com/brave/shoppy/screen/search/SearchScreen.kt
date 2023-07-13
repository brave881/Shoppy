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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.ui.theme.dialogBackgroundColor
import com.brave.shoppy.ui.theme.dialogOutsideBackgroundColor
import com.brave.shoppy.ui.theme.filterBackgroundColor
import com.brave.shoppy.ui.theme.primaryTextFieldBackground
import com.brave.shoppy.utils.ItemReview
import com.brave.shoppy.utils.betweenTextPadding
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.buttons.PrimaryImageButton
import com.brave.shoppy.utils.buttons.PrimaryTextButton
import com.brave.shoppy.utils.largeCardSize_78
import com.brave.shoppy.utils.largeCornerShape_15
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.largeVerticalPadding_24
import com.brave.shoppy.utils.mediumCardSize_48
import com.brave.shoppy.utils.mediumCornerShape_10
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallPadding_10
import com.brave.shoppy.utils.textFields.SecondaryTextField
import com.brave.shoppy.utils.types.CategoryType
import com.brave.shoppy.utils.types.SearchType
import com.brave.shoppy.utils.types.SizeType

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
        var sizeType by remember { mutableStateOf(SizeType.DEFAULT) }
        var searchType by remember { mutableStateOf(SearchType.DEFAULT) }
        var categoryType by remember { mutableStateOf(CategoryType.DEFAULT) }

        if (filterDialogState) {
            Dialog(
                onDismissRequest = {
                    filterDialogState = false
                    sizeType = SizeType.DEFAULT
                    searchType = SearchType.DEFAULT
                    categoryType = CategoryType.DEFAULT
                }, properties = DialogProperties(
                    dismissOnBackPress = true, dismissOnClickOutside = true
                )
            ) {
                Card(
                    Modifier.fillMaxWidth(), shape = RoundedCornerShape(
                        largeCornerShape_15
                    ), colors = CardDefaults.cardColors(containerColor = dialogBackgroundColor)
                ) {
                    Column(Modifier.padding(bottomPadding_20)) {

                        Text(
                            text = stringResource(R.string.filter_search),
                            style = MaterialTheme.typography.displayMedium,
                            modifier = Modifier
                                .padding(bottom = bottomPadding_20)
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = stringResource(R.string.categories),
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier.padding(bottom = bottomPadding_20)
                        )

                        Row(
                            modifier = Modifier
                                .padding(bottom = largeVerticalPadding_24)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            PrimaryImageButton(image = R.drawable.image_1,
                                isClicked = categoryType == CategoryType.SHIRTS,
                                onClick = { categoryType = CategoryType.SHIRTS })
                            PrimaryImageButton(image = R.drawable.pants,
                                isClicked = categoryType == CategoryType.PANTS,
                                onClick = { categoryType = CategoryType.PANTS })
                            PrimaryImageButton(image = R.drawable.image_2,
                                isClicked = categoryType == CategoryType.SHOES,
                                onClick = { categoryType = CategoryType.SHOES })
                            PrimaryImageButton(image = R.drawable.hat,
                                isClicked = categoryType == CategoryType.HATS,
                                onClick = { categoryType = CategoryType.HATS })
                            PrimaryImageButton(image = R.drawable.watch,
                                isClicked = categoryType == CategoryType.ACCESSORIES,
                                onClick = { categoryType = CategoryType.ACCESSORIES })
                        }

                        Text(
                            text = stringResource(R.string.size),
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier.padding(bottom = bottomPadding_20)
                        )

                        Row(
                            Modifier
                                .padding(bottom = largeVerticalPadding_24)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            PrimaryTextButton(
                                letter = stringResource(R.string.s),
                                onClick = { sizeType = SizeType.S },
                                onSelected = sizeType == SizeType.S
                            )
                            PrimaryTextButton(
                                letter = stringResource(R.string.m),
                                onClick = { sizeType = SizeType.M },
                                onSelected = sizeType == SizeType.M
                            )
                            PrimaryTextButton(
                                letter = stringResource(R.string.l),
                                onClick = { sizeType = SizeType.L },
                                onSelected = sizeType == SizeType.L
                            )
                            PrimaryTextButton(
                                letter = stringResource(R.string.xl),
                                onClick = { sizeType = SizeType.XL },
                                onSelected = sizeType == SizeType.XL
                            )
                        }

                        Text(
                            text = stringResource(R.string.search),
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier.padding(bottom = bottomPadding_20)
                        )

                        Row(
                            Modifier
                                .padding(bottom = largeVerticalPadding_24)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(end = betweenTextPadding)
                                    .height(mediumCardSize_48)
                                    .fillMaxWidth()
                                    .weight(1f),
                                shape = RoundedCornerShape(mediumCornerShape_10),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (searchType == SearchType.BESTSELLER) MaterialTheme.colorScheme.primary else primaryTextFieldBackground
                                ),
                            ) {
                                Box(modifier = Modifier
                                    .clickable {
                                        searchType = SearchType.BESTSELLER
                                    }
                                    .fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Text(
                                        text = stringResource(R.string.best_seller),
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .padding(start = betweenTextPadding)
                                    .height(mediumCardSize_48)
                                    .fillMaxWidth()
                                    .weight(1f),
                                shape = RoundedCornerShape(mediumCornerShape_10),
                                colors = CardDefaults.cardColors(
                                    containerColor = if (searchType == SearchType.CHEAPEST) MaterialTheme.colorScheme.primary else primaryTextFieldBackground
                                ),
                            ) {
                                Box(modifier = Modifier
                                    .clickable {
                                        searchType = SearchType.CHEAPEST
                                    }
                                    .fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Text(
                                        text = stringResource(R.string.cheapest),
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }
                            }
                        }

                        PrimaryBlueButton(text = stringResource(R.string.done),
                            onSelected = true,                                                      ///
                            modifier = Modifier
                                .padding(bottom = smallPadding_10)
                                .fillMaxWidth(),
                            onClick = {

                            })

                        Button(
                            onClick = {
                                sizeType = SizeType.DEFAULT
                                searchType = SearchType.DEFAULT
                                categoryType = CategoryType.DEFAULT
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(
                                mediumCornerShape_10
                            ),
                            colors = ButtonDefaults.buttonColors(containerColor = primaryTextFieldBackground)
                        ) {
                            Text(
                                text = stringResource(R.string.reset_to_default),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }
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
                    Text(text = stringResource(R.string.search))
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
                    SecondaryTextField(
                        text = query,
                        placeHolder = stringResource(R.string.write_here),
                        onValueChange = { query = it },
                        icon = R.drawable.search,
                        onCLick = {

                        }
                    )
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

