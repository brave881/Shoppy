package com.brave.shoppy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.brave.shoppy.R

// Set of Material typography styles to start with
val Typography = Typography(
    displaySmall = TextStyle(
        // H3
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(700),
        color = Color(0xFF000000),
    ),
    displayMedium = TextStyle(
        // H2
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(600),
        color = Color(0xFF000000),
    ),
    //h4
    headlineMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(400),
        color = Color(0xFF000000),
    ),
//// semibold/h3
//    semibold = TextStyle(
//        fontSize = 16.sp,
//        fontFamily = FontFamily(Font(R.font.nunito)),
//        fontWeight = FontWeight(600),
//        color = Color(0xFF1F1F24),
//    )

    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(700),
        color = Color(0xFF63A1FF),
        textAlign = TextAlign.Center,
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(700),
        color = Color(0xFF63A1FF),
        textAlign = TextAlign.Center,
    ),

    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.nunito)),
        fontWeight = FontWeight(700),
        color = Color(0xCC1F1F24),
        textAlign = TextAlign.Center,
    )
)
val styleCargoName_16 = TextStyle(
    fontSize = 16.sp,
    fontFamily = FontFamily(Font(R.font.nunito)),
    fontWeight = FontWeight(700),
    color = Color(0xFFF8F8F8),
)
val styleCargoDeliverDate_16 = TextStyle(
    fontSize = 16.sp,
    fontFamily = FontFamily(Font(R.font.nunito)),
    fontWeight = FontWeight(600),
    color = Color(0xCCF8F8F8),
)
