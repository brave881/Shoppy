package com.brave.shoppy.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brave.domain.use_case.SignInStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val direction: SplashScreenDirection,
    private val signInStateUseCase: SignInStateUseCase
):ViewModel(){

    init {
        viewModelScope.launch {
            delay(2000)
            if (signInStateUseCase.invoke() != null){
                direction.navigateToHomeScreen()
            }else{
                direction.navigateToSignInScreen()
            }
        }
    }
}
