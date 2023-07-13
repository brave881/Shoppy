package com.brave.shoppy.screen.bag.shipment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.bag.shipment.components.CargoInfoCard
import com.brave.shoppy.screen.bag.shipment.components.PackageStateCard
import com.brave.shoppy.screen.bag.shipment.components.ShipmentAddressesCard
import com.brave.shoppy.ui.theme.settingsHelpBackground
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.card.ImageCard
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.largePadding_24
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallPadding_10
import com.brave.shoppy.utils.largeCardSize_78
import com.brave.shoppy.utils.largeCardSize_90


class ShipmentScreen : AppScreen() {
    @Composable
    override fun Content() {

        ShipmentScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ShipmentScreenContent() {


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
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = bottomPadding_20
                    )
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.your_items),
                        modifier = Modifier
                            .padding(horizontal = largeHorizontalPadding_24)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall
                    )

                    Row(
                        Modifier
                            .clickable {

                            }
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = primaryPadding
                            )
                            .fillMaxWidth()
                    ) {
                        ImageCard(
                            modifier = Modifier.size(
                                width = largeCardSize_78,
                                height = largeCardSize_90
                            ), image =R.drawable.placeholder
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(start = primaryPadding)
                                .height(largeCardSize_90)
                        ) {
                            Text(
                                text = "Acapella Black Jacket",
                                style = MaterialTheme.typography.displaySmall
                            )
                            Text(
                                text = "x1",
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "$240",
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }

                    Text(
                        text = stringResource(R.string.details),
                        modifier = Modifier
                            .padding(
                                start = largePadding_24,
                                top = smallPadding_10,
                                end = largePadding_24,
                                bottom = primaryPadding
                            )
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall
                    )
                    CargoInfoCard(image = R.drawable.fedex, name = "FedEx Express", onClick = {

                    }, text = "Estimated day: 13 - 16 Jun")
                    ShipmentAddressesCard(
                        fromAddress = "709 Faeh Ave",
                        toAddress = "32, Hancock St"
                    )

                    PackageStateCard(
                        icon = R.drawable.flag,
                        text = "Your package has arrived",
                        contentColor = MaterialTheme.colorScheme.primary,
                        containerColor = settingsHelpBackground
                    )

                }
                PrimaryBlueButton(
                    Modifier.padding(horizontal = largeHorizontalPadding_24),
                    text = stringResource(R.string.confirm),
                    isCanConfirm = true
                ) {

                }
            }
        }
    }
}