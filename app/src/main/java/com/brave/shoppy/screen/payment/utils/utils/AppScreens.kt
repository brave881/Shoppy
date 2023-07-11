package com.brave.shoppy.screen.payment.utils.utils

import com.brave.shoppy.screen.address.AddressScreen
import com.brave.shoppy.screen.bag.BagScreen
import com.brave.shoppy.screen.cart.CartScreen
import com.brave.shoppy.screen.comment.CommentScreen
import com.brave.shoppy.screen.details.DetailsScreen
import com.brave.shoppy.screen.favourite.FavouriteScreen
import com.brave.shoppy.screen.home.HomeScreen
import com.brave.shoppy.screen.oreder_review.OrderReviewScreen
import com.brave.shoppy.screen.payment.PaymentScreen
import com.brave.shoppy.screen.search.SearchScreen
import com.brave.shoppy.screen.settings.SettingsScreen
import com.brave.shoppy.screen.settings.edit_language.EditLanguageScreen
import com.brave.shoppy.screen.settings.edit_profile.EditProfileScreen
import com.brave.shoppy.screen.bag.shipment.ShipmentScreen
import com.brave.shoppy.screen.sign_in.SignInScreen
import javax.inject.Inject

class AppScreens @Inject constructor() {
    fun signInScreen() = SignInScreen()
    fun editProfileScreen() = EditProfileScreen()
    fun editLanguage() = EditLanguageScreen()
    fun homeScreen(): HomeScreen = HomeScreen()
    fun addressScreen() = AddressScreen()
    fun bagScreen() = BagScreen()
    fun cartScreen() = CartScreen()
    fun commentScreen() = CommentScreen()
    fun detailsScreen(): DetailsScreen = DetailsScreen()
    fun favouriteScreen() = FavouriteScreen()
    fun orderReviewScreen() = OrderReviewScreen()
    fun paymentScreen() = PaymentScreen()
    fun searchScreen() = SearchScreen()
    fun settingsScreen() = SettingsScreen()
    fun shipmentScreen() = ShipmentScreen()

}
