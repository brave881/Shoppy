package com.brave.shoppy.screen.bag

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.navigation.AppScreen

class BagScreen : AppScreen() {
    @Composable
    override fun Content() {
        BagScreenContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun BagScreenContent() {

        Scaffold(bottomBar = {
            Card(
                Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(15.dp),

                ) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.bag),
                        contentDescription = "",
                        modifier = Modifier.clickable {

                        },)
                    Icon(painter = painterResource(id = R.drawable.bag), contentDescription = "")
                    Icon(painter = painterResource(id = R.drawable.bag), contentDescription = "")
                    Icon(painter = painterResource(id = R.drawable.bag), contentDescription = "")
                }
            }

        }) {

        }
    }
}
