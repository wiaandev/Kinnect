package com.example.kinnect

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kinnect.Screens.ConversationsScreen
import com.example.kinnect.viewModels.AuthViewModel
import com.example.kinnect.Screens.HouseholdCreateScreen
import com.example.kinnect.Screens.LoginScreen
import com.example.kinnect.Screens.RegisterScreen

enum class AuthRoutes {
    Login,
    Register
}

enum class HomeRoutes {
    Conversations,
    Chat,
    Profile,
    Household

}

// Generating our navigation Navhost
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel,
){

    val startingScreen = if(authViewModel.hasUser){
            HomeRoutes.Conversations.name
        } else {
            AuthRoutes.Login.name
        }

//  Identifying our navHost and that it should use my navController
    NavHost(
        navController = navController,
        startDestination = startingScreen){

        //define all the screens I can navigate to

        // my login screen
        composable(route= AuthRoutes.Login.name){
            LoginScreen(
                onNavigateToRegister = { navController.navigate(AuthRoutes.Register.name){
                    launchSingleTop = true
                    popUpTo(route = AuthRoutes.Login.name){
                        inclusive = true
                    }
                }
                }, authViewModel = authViewModel)
        }

        // my Register screen
        composable(route= AuthRoutes.Register.name){
            RegisterScreen(
                onNavigateToLogin = {navController.navigate(AuthRoutes.Login.name){
                    launchSingleTop = true
                    popUpTo(route = AuthRoutes.Register.name){
                        inclusive = true
                    }
                }}, authViewModel = AuthViewModel()
            )
        }

//        composable(route = HomeRoutes.Conversations.name){
//            ConversationsScreen(onSignOut = {navController.navigate(AuthRoutes.Login.name){
//                launchSingleTop = true
//                popUpTo(route = AuthRoutes.Login.name){
//                    inclusive = true
//                }
//            } })
//        }

        composable(route = HomeRoutes.Conversations.name){
            ConversationsScreen(onNavigateHousehold = {navController.navigate(AuthRoutes.Register.name){
                launchSingleTop = true
                popUpTo(route = AuthRoutes.Register.name){
                    inclusive = true
                }
            } }, authViewModel = AuthViewModel())
        }

        composable(route = HomeRoutes.Household.name){
            HouseholdCreateScreen(onNavigateToConversation = {navController.navigate(HomeRoutes.Conversations.name){
                launchSingleTop = true
                popUpTo(route = HomeRoutes.Conversations.name){
                    inclusive = true
                }
            } })
        }

        //TODO: Create links to profile & chat screen (pass data)
        //TODO: Setup our auth
    }
}