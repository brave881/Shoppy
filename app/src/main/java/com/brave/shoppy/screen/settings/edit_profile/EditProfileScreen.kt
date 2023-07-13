package com.brave.shoppy.screen.settings.edit_profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.settings.components.GenderButton
import com.brave.shoppy.utils.types.GenderType
import com.brave.shoppy.utils.card.ImageCard
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.textFields.PrimaryTextField
import com.brave.shoppy.utils.betweenTextFieldPadding_8
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.validators.isEmail
import com.brave.shoppy.utils.validators.isPhone
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.primaryPadding
import com.brave.shoppy.utils.smallPadding_10
import com.brave.shoppy.utils.xLargeCardSize_100


class EditProfileScreen : AppScreen() {
    @Composable
    override fun Content() {
        EditProfileScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun EditProfileScreenContent() {

        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var genderType by remember { mutableStateOf(GenderType.UNKNOWN) }

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
                    Text(text = stringResource(R.string.edit_profile))
                })
        }) { paddingValues ->
            Column(
                Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(), bottom = bottomPadding_20
                    )
                    .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageCard(
                        image = R.drawable.placeholder,
                        modifier = Modifier.size(xLargeCardSize_100)
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = primaryPadding, bottom = smallPadding_10)
                            .clickable {

                            },
                        text = stringResource(R.string.change_image),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Row(
                        Modifier
                            .padding(
                                start = largeHorizontalPadding_24,
                                end = largeHorizontalPadding_24,
                                top = primaryPadding
                            )
                            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        PrimaryTextField(
                            Modifier
                                .padding(end = betweenTextFieldPadding_8)
                                .weight(1f),
                            text = firstName,
                            title = stringResource(R.string.first_name),
                            onTextChange = { firstName = it })
                        PrimaryTextField(
                            Modifier
                                .padding(start = betweenTextFieldPadding_8)
                                .weight(1f),
                            text = lastName,
                            title = stringResource(R.string.last_name),
                            onTextChange = { lastName = it })
                    }
                    PrimaryTextField(
                        Modifier
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = betweenTextFieldPadding_8
                            )
                            .fillMaxWidth(),
                        text = userName,
                        title = stringResource(R.string.username),
                        onTextChange = { userName = it })
                    Row(
                        Modifier
                            .padding(
                                horizontal = largeHorizontalPadding_24, betweenTextFieldPadding_8
                            )
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.gender),
                            style = MaterialTheme.typography.titleSmall
                        )
                        Row {
                            GenderButton(modifier = Modifier.padding(end = betweenTextFieldPadding_8),
                                isClicked = genderType == GenderType.MALE,
                                onClick = { genderType = GenderType.MALE })
                            GenderButton(isMale = false,
                                modifier = Modifier.padding(start = betweenTextFieldPadding_8),
                                isClicked = genderType == GenderType.FEMALE,
                                onClick = { genderType = GenderType.FEMALE })
                        }
                    }
                    PrimaryTextField(
                        Modifier
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = betweenTextFieldPadding_8
                            )
                            .fillMaxWidth(),
                        text = phoneNumber,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        title = stringResource(R.string.phone_number),
                        onTextChange = { phoneNumber = it })
                    PrimaryTextField(
                        Modifier
                            .padding(
                                horizontal = largeHorizontalPadding_24,
                                vertical = betweenTextFieldPadding_8
                            )
                            .fillMaxWidth(),
                        text = email,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        title = stringResource(R.string.email),
                        onTextChange = { email = it })

                }
                PrimaryBlueButton(
                    Modifier.padding(horizontal = largeHorizontalPadding_24),
                    text = stringResource(R.string.confirm),
                    isCanConfirm = firstName.isNotBlank() && lastName.isNotBlank() && userName.isNotBlank() && phoneNumber.isPhone() && email.isEmail() && genderType != GenderType.UNKNOWN
                ) {

                }
            }
        }
    }
}
