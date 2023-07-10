package com.brave.shoppy.screen.address

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
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.address.components.AddressDetailCard
import com.brave.shoppy.ui.theme.spacing

class AddressScreen : AppScreen() {
    @Composable
    override fun Content() {
        AddressScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddressScreenContent() {

        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()
        var query by remember { mutableStateOf("") }
        var search by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }


        BottomSheetScaffold(
            scaffoldState = scaffoldState,
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
                                AddressDetailCard(
                                    city = "Indonesian, Cilacap", street = "32, Stasiun Street"
                                )
                                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                            }
                        }

                    }

                }
            }) { innerPadding ->

            Box(Modifier.padding(innerPadding)) {

            }
        }
    }


}
