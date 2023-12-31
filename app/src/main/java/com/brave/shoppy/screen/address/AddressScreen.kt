package com.brave.shoppy.screen.address

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.MyTopAppBar
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.card.PrimaryReviewDetailCard

class AddressScreen : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<AddressScreenViewModel>()
        AddressScreenContent(viewModel::onEventDispatcher)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddressScreenContent(onEventDispatcher: (AddressScreenEvent) -> Unit) {

        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()
        var search by remember { mutableStateOf("") }
        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }



        Scaffold(bottomBar = {
            PrimaryBlueButton(
                text = "Go to payment", modifier = Modifier.padding(
                    MaterialTheme.spacing.medium
                )
            ) {
                onEventDispatcher(AddressScreenEvent.NavigateToPaymentScreen)

            }
        }, content = {
            BottomSheetScaffold(scaffoldState = scaffoldState,
                sheetPeekHeight = 350.dp,
                sheetContent = {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(MaterialTheme.spacing.small),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SearchBar(query = query,
                            onQueryChange = { query = it },
                            onSearch = { search = it },
                            active = active,
                            onActiveChange = { active = it },
                            placeholder = { Text(text = "Search your City or street name  ") },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    contentDescription = "Search icon"
                                )
                            }) {}
                        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(MaterialTheme.spacing.medium)
                        ) {

                            Text(
                                text = "Your address",
                                style = MaterialTheme.typography.displaySmall.copy(
                                    fontFamily = FontFamily(Font(R.font.nunito_bold)),
                                    textAlign = TextAlign.Start
                                ),
                                modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
                            )
                            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                                items(3) {
                                    PrimaryReviewDetailCard(
                                        title = "Indonesian, Cilacap",
                                        subTitle = "32, Stasiun Street",
                                    )
                                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                                }
                            }

                        }

                    }
                },
                topBar = {
                    MyTopAppBar(title = "Address") {
                        onEventDispatcher(AddressScreenEvent.Back)
                    }


                }) { innerPadding ->

                Box(Modifier.padding(innerPadding)) {
//                    MapBoxMap(point = )

                }
            }
        })
    }


}
