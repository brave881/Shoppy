package com.brave.shoppy.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brave.shoppy.R
import com.brave.shoppy.ui.theme.ShoppyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    title: String, onClickIcon: () -> Unit
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        navigationIcon = {
            IconButton(onClick = onClickIcon) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = "Back icon",
                )
            }
        },
        title = {
            Row(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                )
            }
        },
    )


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopAppBarPreview() {
    ShoppyTheme() {
        MyTopAppBar(
            title = "Settings"
        ) {}
    }
}
