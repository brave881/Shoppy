package com.brave.shoppy.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.brave.shoppy.ui.theme.black20
import com.brave.shoppy.ui.theme.primary100





//@Composable
//fun BottomNavigation(
//    modifier: Modifier = Modifier, content: @Composable () -> Unit
//) {
//    Card(
//        modifier = modifier
//            .height(70.dp)
//            .padding(start = 8.dp, end = 8.dp)
//            .fillMaxWidth(),
//        shape = RoundedCornerShape(18.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            content()
//        }
//    }
//
//}
//
//@Composable
//fun BottomSheetItem(
//    modifier: Modifier = Modifier, icon: Int, isIconSelected: Boolean, onClick: () -> Unit
//) {
//    Icon(
//        painter = painterResource(icon),
//        contentDescription = "Bottom navigation icon",
//        modifier = modifier
//            .width(24.dp)
//            .height(24.dp)
//            .clickable {
//                onClick()
//            },
//        tint = if (isIconSelected) primary100 else black20
//    )
//}
