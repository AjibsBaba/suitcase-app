package com.application.suitcase

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.application.suitcase.ui.auth.login.LoginScreen
import com.application.suitcase.ui.auth.login.LoginViewModel
import com.application.suitcase.ui.auth.passwordReset.PasswordResetScreen
import com.application.suitcase.ui.auth.passwordReset.PasswordResetViewModel
import com.application.suitcase.ui.auth.register.RegistrationScreen
import com.application.suitcase.ui.auth.register.RegistrationViewModel
import com.application.suitcase.ui.home.HomeScreen
import com.application.suitcase.ui.home.HomeViewModel
import com.application.suitcase.ui.onboarding.OnboardingScreen
import com.application.suitcase.ui.profile.ProfileScreen
import com.application.suitcase.ui.suitcase.AddSuitcase
import com.application.suitcase.ui.suitcase.PurchasedScreen
import com.application.suitcase.ui.suitcase.SuitcaseViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Destinations used in the ([SuitcaseApp])
 */



@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationRoutes.ONBOARDING_SCREEN) {


    val loginViewModel = remember { LoginViewModel() }

    val auth: FirebaseAuth = Firebase.auth

    LaunchedEffect(auth) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            navController.navigate(NavigationRoutes.HOME_SCREEN)
        } else {
            navController.navigate(NavigationRoutes.ONBOARDING_SCREEN)
        }
    }


    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationRoutes.ONBOARDING_SCREEN) {
            OnboardingScreen(navController = navController)
        }
        composable(NavigationRoutes.LOGIN_SCREEN) {
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }
        composable(NavigationRoutes.REGISTRATION_SCREEN) {
            RegistrationScreen(viewModel = RegistrationViewModel(), navController = navController)
        }
        composable(NavigationRoutes.PASSWORD_RESET_SCREEN) {
            PasswordResetScreen(viewModel = PasswordResetViewModel(), navController = navController)
        }
        composable(NavigationRoutes.HOME_SCREEN) {
            HomeScreen(viewModel = HomeViewModel(), navController = navController)
        }
        composable(NavigationRoutes.SUITCASE_SCREEN) {
            AddSuitcase(viewModel = SuitcaseViewModel(), navController = navController)
        }
        composable(NavigationRoutes.PROFILE_SCREEN) {
            ProfileScreen(navController = navController, viewModel = HomeViewModel())
        }
        composable(NavigationRoutes.PURCHASED_SCREEN) {
            PurchasedScreen(navController = navController, viewModel = SuitcaseViewModel())
        }
    }
}