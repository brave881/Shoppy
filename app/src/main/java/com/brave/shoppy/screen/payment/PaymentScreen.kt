package com.brave.shoppy.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen
import com.brave.shoppy.screen.payment.utils.CardUtil
import com.brave.shoppy.ui.theme.size
import com.brave.shoppy.ui.theme.spacing
import com.brave.shoppy.utils.MyTopAppBar
import com.brave.shoppy.utils.buttons.PrimaryBlueButton
import com.brave.shoppy.utils.textFields.PrimaryTextField
import com.brave.shoppy.utils.validators.trimmerCardNumber
import com.brave.shoppy.utils.validators.trimmerDate
import com.steliospapamichail.creditcardmasker.viewtransformations.CardNumberMask
import com.steliospapamichail.creditcardmasker.viewtransformations.ExpirationDateMask
import java.util.Locale

class PaymentScreen : AppScreen() {
    @Composable
    override fun Content() {
        PaymentScreenContent()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun PaymentScreenContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyTopAppBar(title = "Payment") {

                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Add credit card",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_bold)
                            ), textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.padding(
                            top = MaterialTheme.spacing.medium,
                            start = MaterialTheme.spacing.medium,

                            )
                    )
                    var cardName by remember { mutableStateOf("") }
                    var cardNumber by remember { mutableStateOf("") }
                    var expiryDate by remember { mutableStateOf("") }
                    var cVV by remember { mutableStateOf("") }

                    var isValidCvv by remember { mutableStateOf(false) }
                    var isValidCardNumber by remember { mutableStateOf(false) }
                    var isValidExpiryDate by remember { mutableStateOf(false) }


                    PrimaryTextField(
                        text = cardName,
                        title = "Card name",
                        onTextChange = { cardName = it },
                        placeholder = {
                            Text(
                                text = "Write here",
                                style = MaterialTheme.typography.displaySmall.copy(
//                                    color = MaterialTheme.colorScheme.secondaryContainer
                                )
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                MaterialTheme.spacing.medium
                            )
                    )


                    PrimaryTextField(
                        text = cardNumber,
                        title = "Card number",
                        onTextChange = {
                            if (it.length <= 16) {
                                cardNumber = it.replace("[^0-9]+".toRegex(), "")
                            }
                        },
                        placeholder = {
                            Text(
                                text = "Write here",
                                style = MaterialTheme.typography.displaySmall.copy(
//                                    color = MaterialTheme.colorScheme.secondaryContainer
                                )
                            )
                        },
                        isError = isValidCardNumber,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = MaterialTheme.spacing.medium,
                                end = MaterialTheme.spacing.medium,
                                start = MaterialTheme.spacing.medium
                            ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        visualTransformation = CardNumberMask()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = MaterialTheme.spacing.medium,
                                end = MaterialTheme.spacing.medium,
                                start = MaterialTheme.spacing.medium
                            ),
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
                    ) {
                        PrimaryTextField(
                            text = expiryDate,
                            title = "Expiry date",
                            onTextChange = {
                                if (it.length <= 4) expiryDate = it.replace("[^0-9]+".toRegex(), "")
                            },
                            visualTransformation = ExpirationDateMask(),
                            placeholder = {
                                Text(
                                    text = "Write here",
                                    style = MaterialTheme.typography.displaySmall.copy(
//                                    color = MaterialTheme.colorScheme.secondaryContainer
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(0.5f),
                            isError = isValidExpiryDate
                        )
                        PrimaryTextField(
                            text = cVV,
                            title = "CVV",
                            onTextChange = {
                                if (it.length <= 3) cVV = it.replace("[^0-9]+".toRegex(), "")
                            },
                            placeholder = {
                                Text(
                                    text = "Write here",
                                    style = MaterialTheme.typography.displaySmall.copy(
//                                    color = MaterialTheme.colorScheme.secondaryContainer
                                    )
                                )
                            },
                            modifier = Modifier.weight(0.5f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                        )
                    }

                    Text(
                        text = "Your credit card",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = FontFamily(
                                Font(R.font.nunito_bold)
                            ), textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.padding(
                            top = MaterialTheme.spacing.medium,
                            start = MaterialTheme.spacing.medium,
                            bottom = MaterialTheme.spacing.small
                        )
                    )


                    if (cVV.isNotBlank()) isValidCvv = CardUtil.isValidCVC(cVV.toInt())
                    if (cardNumber.isNotBlank()) isValidCardNumber =
                        CardUtil.isValidCardNumber(cardNumber.toLong())
                    if (expiryDate.length == 4) {
                        val month = expiryDate.substring(0, 2)
                        val year = expiryDate.substring(2, 4)
                        isValidExpiryDate =
                            CardUtil.isValidExpirationDate(month.toInt(), year.toInt())

                    }

                    CreditCard(
                        cardNumber, cardName, expiryDate, cVV
                    )
                    Scaffold(bottomBar = {
                        PrimaryBlueButton(
                            text = "Go to payment",
                            modifier = Modifier.padding(MaterialTheme.spacing.medium),
                            onClick = {},
                            onSelected = isValidCardNumber && isValidCvv
                        )
                    }) {

                    }


                }
            }
        }
    }


    @Composable
    private fun CreditCard(
        cardNumber: String, cardName: String, expiryDate: String, cVV: String
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.size.cardHeight)
                .padding(
                    top = MaterialTheme.spacing.medium,
                    start = MaterialTheme.spacing.medium,
                    end = MaterialTheme.spacing.medium
                ), shape = MaterialTheme.shapes.extraLarge, colors = CardDefaults.cardColors()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = MaterialTheme.spacing.medium,
                            top = MaterialTheme.spacing.medium,
                            end = MaterialTheme.spacing.medium,
                        ), horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Credit card", style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.mastercard_icon),
                        contentDescription = null
                    )

                }

                Text(
                    text = trimmerCardNumber(cardNumber),
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily(
                            Font(R.font.nunito_regular)
                        ), textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.padding(
//                        top = MaterialTheme.spacing.medium,
                        start = MaterialTheme.spacing.medium
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium
                        )
                ) {

                    Column(
                        modifier = Modifier.weight(0.3f)
                    ) {
                        Text(
                            text = "EXP", style = MaterialTheme.typography.headlineMedium.copy()
                        )
                        Text(
                            text = trimmerDate(expiryDate),
                            style = MaterialTheme.typography.displaySmall.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_semi_bold)),
                            ),
                            maxLines = 1
                        )
                    }

                    Column(
                        modifier = Modifier.weight(0.3f)
                    ) {
                        Text(
                            text = "CVV", style = MaterialTheme.typography.headlineMedium.copy()
                        )
                        Text(
                            text = cVV, style = MaterialTheme.typography.displaySmall.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                            ), maxLines = 1
                        )
                    }



                    Column(
                        modifier = Modifier.weight(0.8f)
                    ) {
                        Text(
                            text = "Card name",
                            style = MaterialTheme.typography.headlineMedium.copy()
                        )
                        Text(
                            text = cardName.uppercase(Locale.ROOT),
                            style = MaterialTheme.typography.displaySmall.copy(
                                fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
                            ),
                            maxLines = 1
                        )
                    }
                }

            }


        }

    }
}
