package com.project.capstone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.capstone.feature.auth.login.presentation.LoginScreen
import com.project.capstone.feature.auth.register.presentation.RegisterScreen
import com.project.capstone.feature.home.HomeScreen
import com.project.capstone.feature.onboarding.presentation.OnboardingScreen
import com.project.capstone.feature.profile.ProfileScreen
import com.project.capstone.feature.sekerja.SekerjaScreen
import com.project.capstone.feature.sertifikat.SertifikatScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route ) {

        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Sekerja.route) {
            SekerjaScreen(navController = navController)
        }

        composable(route = Screen.Sertifikat.route) {
            SertifikatScreen(navController = navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}



