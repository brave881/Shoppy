package com.brave.shoppy.screen.sign_in

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.buttons.PrimaryRedButton
import com.brave.shoppy.utils.dialogs.DialogBoxLoading
import com.brave.shoppy.utils.extraLarge
import com.brave.shoppy.utils.large
import com.brave.shoppy.utils.small
import com.brave.shoppy.utils.smallPadding_10

class SignInScreen : AppScreen() {


    @Composable
    override fun Content() {
        val viewModel = getViewModel<SignInScreenViewModel>()
        SignInScreenContent(viewModel)
    }
}

@Composable
fun SignInScreenContent(viewModel: SignInScreenViewModel) {
    val state = viewModel.state
    val context = LocalContext.current
    val lifecycleScope = rememberCoroutineScope()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    if (state.value.loading) {
        DialogBoxLoading()
    } else if (state.value.error.isNotEmpty()) {
        LaunchedEffect(key1 = Unit) {
            Toast.makeText(context, state.value.error, Toast.LENGTH_SHORT).show()
        }
    }






    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(0.70f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Shoppy",
                        fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = large,
                        textAlign = TextAlign.Center
                    )
                    Image(
                        modifier = Modifier
                            .padding(top = MaterialTheme.spacing.small)
                            .height(100.dp)
                            .width(100.dp),
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo of shoppy"
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.spacing.medium)
                        .weight(0.6f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "E-mail") },
                        shape = RoundedCornerShape(20.dp),
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(smallPadding_10))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Password") },
                        shape = RoundedCornerShape(20.dp),
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                    PrimaryRedButton(text = "Register") {
                        viewModel.onEvent(SignInScreenEvent.SignIn(email.trim(), password.trim()))
                    }
//                    Text(text = "Or", style = MaterialTheme.typography.displayMedium)
//                    PrimaryRedButton(text = "Sign up", modifier = Modifier.width(150.dp)) {
//
//                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.30f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Discover you style",
                    fontSize = extraLarge,
                    fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Get quality and classy products at very\n" + "affordable prices.",
                    fontSize = small,
                    fontFamily = FontFamily(Font(R.font.nunito)),
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    ShoppyTheme() {
//        SignInScreenContent()
    }
}
