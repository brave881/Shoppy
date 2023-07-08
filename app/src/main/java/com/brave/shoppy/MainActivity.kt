package com.brave.shoppy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.brave.shoppy.navigation.NavigationHandler
import com.brave.shoppy.screen.bag.BagScreen
import com.brave.shoppy.screen.favourite.FavouriteScreen
import com.brave.shoppy.screen.home.HomeScreen
import com.brave.shoppy.screen.sign_in.SignInScreen
import com.brave.shoppy.ui.theme.ShoppyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppyTheme {

                Navigator(screen = SignInScreen()) { navigator ->
                    LaunchedEffect(key1 = navigator) {
                        navigationHandler.navigationArgs.onEach {
                            it.invoke(navigator)
                        }.collect()
                    }
                    CurrentScreen()


                  /*  TabNavigator(HomeScreen()) { tabNavigator ->
                        Scaffold(content = {
                            CurrentTab()
                        }, bottomBar = {
                            Card(
                                shape = RoundedCornerShape(size = 15.dp),
                                modifier = Modifier
                                    .padding(all = 16.dp)
                                    .height(60.dp)
                            ) {
                                NavigationBar {
                                    TabNavigationItem(tab = HomeScreen())
                                    TabNavigationItem(tab = BagScreen())
                                    TabNavigationItem(tab = FavouriteScreen())
                                    TabNavigationItem(tab = HomeScreen())
                                }
                            }
                        })
                    }*/
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { tab.icon?.let { Icon(painter = it, contentDescription = tab.options.title) } })
}
