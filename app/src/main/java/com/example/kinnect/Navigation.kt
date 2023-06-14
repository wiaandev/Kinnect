package com.example.kinnect

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kinnect.Screens.ChatScreen
import com.example.kinnect.Screens.ConversationsScreen
import com.example.kinnect.viewModels.AuthViewModel
import com.example.kinnect.Screens.LoginScreen
import com.example.kinnect.Screens.ProfileScreen
import com.example.kinnect.Screens.RegisterScreen

enum class AuthRoutes {
    Login,
    Register
}

enum class HomeRoutes {
    Conversations,
    Chat,
    Profile
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
                }, authViewModel = authViewModel,
            onNavToConversations = {
                navController.navigate(HomeRoutes.Conversations.name){
                    launchSingleTop = true
                    popUpTo(route = AuthRoutes.Login.name){
                        inclusive = true
                    }
                }
            })
        }

        // my Register screen
        composable(
            route= AuthRoutes.Register.name
        ){
            RegisterScreen(
                onNavigateToLogin = {navController.navigate(AuthRoutes.Login.name){
                    launchSingleTop = true
                    popUpTo(route = AuthRoutes.Register.name){
                        inclusive = true
                    }
                }},
                onNavigateToConversations = {
                    navController.navigate(HomeRoutes.Conversations.name){
                        launchSingleTop = true
                        popUpTo(route = AuthRoutes.Register.name){
                            inclusive = true
                        }
                    }
                },
                authViewModel = AuthViewModel(),
            )
        }

        composable(route = HomeRoutes.Conversations.name){
            ConversationsScreen(onNavigateHousehold = {navController.navigate(AuthRoutes.Register.name){
                launchSingleTop = true
                popUpTo(route = AuthRoutes.Register.name){
                    inclusive = true
                }
            } }, authViewModel = AuthViewModel(),
                onNavToProfile = {navController.navigate(HomeRoutes.Profile.name){
                    launchSingleTop = true
                    popUpTo(route = HomeRoutes.Conversations.name){
                        inclusive = true
                    }
                }
                },
                onNavToChat = {
                    navController.navigate("${HomeRoutes.Chat.name}/${it}") {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(route = HomeRoutes.Profile.name){
            ProfileScreen(
                navOnSignOut = { navController.navigate(AuthRoutes.Login.name) {
                    launchSingleTop = true
                    popUpTo(route = HomeRoutes.Profile.name){
                        inclusive = true
                    }
                } },
                navBack = { navController.navigate(HomeRoutes.Conversations.name){
                    launchSingleTop = true
                    popUpTo(route = HomeRoutes.Conversations.name)
                } })
        }
        
        composable(
            route = "${HomeRoutes.Chat.name}/{chatId}",
            arguments = listOf(navArgument("chatId"){type = NavType.StringType; defaultValue = "chat1234"})
        ){
            ChatScreen(modifier = Modifier, onNavigateBack = {}, chatId = it.arguments?.getString("chatId"), name = it.arguments?.getString("name"))
        }
    }
}