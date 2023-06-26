package com.brave.shoppy.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class NavigationHandler @Inject constructor() : AppNavigator, NavigationDispatcher {


    override suspend fun navigateTo(screen: AppScreen) = navigator {
        push(screen)
    }

    private suspend fun navigator(args: NavigationArgs) {
        navigationArgs.emit(args)
    }


    override suspend fun navigateTo(screen: List<AppScreen>) = navigator {
        push(screen)
    }

    override suspend fun replace(screen: AppScreen) = navigator {
        replace(screen)
    }

    override suspend fun replaceAll(screen: List<AppScreen>) = navigator {
        replaceAll(screen)
    }

    override suspend fun replaceTo(screen: AppScreen) = navigator {
        replaceAll(screen)
    }

    override suspend fun <T : AppScreen> backUntil(clazz: Class<T>) = navigator {
        popUntil {
            it::class == clazz
        }
    }


    override suspend fun back() = navigator {
        pop()
    }


    override val navigationArgs = MutableSharedFlow<NavigationArgs>()


}
