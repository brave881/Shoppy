package com.brave.shoppy.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.settings.components.SettingsHelpCard
import com.brave.shoppy.utils.Chevron
import com.brave.shoppy.utils.card.ImageCard
import com.brave.shoppy.utils.buttons.PrimaryRedButton
import com.brave.shoppy.screen.settings.components.SettingsItem
import com.brave.shoppy.screen.settings.components.SettingsItemWithToggle
import com.brave.shoppy.utils.betweenTextPadding
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.largePadding_24
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallPadding_10


class SettingsScreen : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<SettingsScreenViewModel>()
        SettingsScreenContent(viewModel::onEventDispatcher)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun SettingsScreenContent(onEvent: (SettingsScreenEvent) -> Unit) {

        var notificationState by remember { mutableStateOf(true) }
        var darkModeState by remember { mutableStateOf(false) }

        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(start = largeHorizontalPadding_24),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            onEvent.invoke(SettingsScreenEvent.Back)
                        })
                },
                title = {
                    Text(text = stringResource(R.string.settings))
                })
        }) { paddingValues ->
            Column(
                Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = bottomPadding_20
                    )
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {

                    Text(
                        text = stringResource(R.string.account),
                        modifier = Modifier
                            .padding(horizontal = largeHorizontalPadding_24)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall
                    )

                    Row(
                        Modifier
                            .clickable {
                                onEvent.invoke(SettingsScreenEvent.NavigateToEditProfile)
                            }
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = primaryPadding
                            )
                            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            ImageCard(image = R.drawable.placeholder)
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.padding(start = primaryPadding)
                            ) {
                                Text(
                                    text = "Wildan Justin",
                                    style = MaterialTheme.typography.displaySmall
                                )
                                Text(
                                    text = "+1 912 321 222",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            }
                        }
                        Chevron()
                    }

                    Text(
                        text = stringResource(R.string.settings),
                        modifier = Modifier
                            .padding(
                                start = largePadding_24,
                                top = smallPadding_10,
                                end = largePadding_24,
                                bottom = betweenTextPadding
                            )
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall
                    )

                    SettingsItem(
                        painter = painterResource(id = R.drawable.language_white),
                        text = stringResource(R.string.language),
                        onClick = {
                            onEvent.invoke(SettingsScreenEvent.NavigateToEditLanguage)
                        })
                    SettingsItem(
                        painter = painterResource(id = R.drawable.map_pin),
                        text = stringResource(R.string.edit_address),
                        onClick = {

                        })
                    SettingsItem(
                        painter = painterResource(id = R.drawable.credit_card),
                        text = stringResource(R.string.edit_credit_card),
                        onClick = {

                        })

                    SettingsItemWithToggle(
                        painter = painterResource(id = R.drawable.bell),
                        text = stringResource(R.string.notification),
                        switchState = notificationState,
                        onCheckedChange = { notificationState = it },
                        onClick = {
                            notificationState = !notificationState
                        })
                    SettingsItemWithToggle(
                        painter = painterResource(id = R.drawable.moon),
                        text = stringResource(R.string.dark_mode),
                        switchState = darkModeState,
                        backgroundColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        onCheckedChange = { darkModeState = it },
                        onClick = {
                            darkModeState = !darkModeState
                        })
                }
                Column(Modifier.fillMaxWidth()) {
                    SettingsHelpCard {

                    }
                    PrimaryRedButton(
                        modifier = Modifier.padding(horizontal = largePadding_24),
                        text = stringResource(R.string.sign_out),
                        icon = R.drawable.log_out
                    ) {

                    }
                }
            }
        }
    }
}
