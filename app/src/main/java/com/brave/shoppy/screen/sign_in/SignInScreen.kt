package com.brave.shoppy.screen.sign_in

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getViewModel
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.utils.PrimaryRedButton
import com.brave.shoppy.ui.theme.ShoppyTheme
import com.brave.shoppy.utils.bottomPadding_20
import com.brave.shoppy.utils.extraLarge
import com.brave.shoppy.utils.large
import com.brave.shoppy.utils.small

class SignInScreen : AppScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<SignInScreenViewModel>()
        SignInScreenContent(viewModel)
    }
}

@Composable
fun SignInScreenContent(viewModel: SignInScreenViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(0.75f),
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

                Spacer(modifier = Modifier.height(80.dp))

                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo of shoppy"
                )
                Spacer(modifier = Modifier.height(80.dp))

                Text(
                    text = "Discover you style",
                    fontSize = extraLarge,
                    fontFamily = FontFamily(Font(R.font.nunito_extra_bold)),
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(20.dp))


                Text(
                    text = "Get quality and classy products at very\n" + "affordable prices.",
                    fontSize = small,
                    fontFamily = FontFamily(Font(R.font.nunito)),
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center
                )
            }


            Column(
                modifier = Modifier.weight(0.25f), verticalArrangement = Arrangement.Bottom
            ) {
                PrimaryRedButton(
                    modifier = Modifier.padding(horizontal = bottomPadding_20),
                    text = "Sign in with Google", icon = R.drawable.google
                ) {
                    viewModel.onEvent(SignInScreenEvent.SignIn("", ""))
//                    Toast.makeText(MainActivity(), "", Toast.LENGTH_LONG).show()
                    Log.d("TAG", "SignInScreenContent: clicked")
                }
                Spacer(modifier = Modifier.height(8.dp))
                PrimaryRedButton(
                    modifier = Modifier.padding(horizontal = bottomPadding_20),
                    text = "Sign in with Facebook", icon = R.drawable.facebook
                ) {

                }
                Spacer(modifier = Modifier.height(8.dp))
                PrimaryRedButton(
                    modifier = Modifier.padding(horizontal = bottomPadding_20),
                    text = "Sign in with Apple", icon = R.drawable.apple
                ) {

                }
                Spacer(modifier = Modifier.height(8.dp))


            }


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    ShoppyTheme() {
//        SignInScreenContent(viewModel)
    }
}
