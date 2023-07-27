package com.brave.shoppy.screen.settings.edit_language

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.settings.components.LanguageButton
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.largeHorizontalPadding_24
import com.brave.shoppy.utils.types.LanguageType

class EditLanguageScreen : AppScreen() {
    @Composable
    override fun Content() {
        EditLanguageScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun EditLanguageScreenContent() {

        val languageType = remember { mutableStateOf(LanguageType.ENGLISH) }

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
                    Modifier
                        .padding(horizontal = largeHorizontalPadding_24)
                        .fillMaxWidth()
                ) {
                    LanguageButton(
                        text = stringResource(R.string.english),
                        languageType = LanguageType.ENGLISH,
                        isClicked = languageType.value == LanguageType.ENGLISH
                    ) {
                        languageType.value = LanguageType.ENGLISH
                    }
                    LanguageButton(
                        text = stringResource(R.string.indonesian),
                        languageType = LanguageType.INDONESIAN,
                        isClicked = languageType.value == LanguageType.INDONESIAN
                    ) {
                        languageType.value = LanguageType.INDONESIAN
                    }
                    LanguageButton(
                        text = stringResource(R.string.thailand),
                        languageType = LanguageType.THAILAND,
                        isClicked = languageType.value == LanguageType.THAILAND
                    ) {
                        languageType.value = LanguageType.THAILAND
                    }
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
