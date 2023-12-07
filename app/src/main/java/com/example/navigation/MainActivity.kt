package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationPage()
                }
            }
        }
    }
}
@Composable
fun NavigationPage(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="anasayfa"){
        composable("anasayfa"){
            Sayfa(navController = navController)
        }
        composable("sayfa_a/{users}",
            arguments = listOf(
                navArgument("users"){type=NavType.StringType},

            ) ){

            val json = it.arguments?.getString("users")
            val users = Gson().fromJson(json,Users::class.java)
            SayfaA(navController = navController,users)

      //      SayfaA(navController = navController, gelenIsım = isim, gelenYas = yas, gelenBoy = boy, gelenBekar = bekar)

        }
        composable("sayfa_b"){
            SayfaB()
        }
    }
}

@Composable
fun Sayfa(navController: NavController){
    val sayac = remember { mutableStateOf(0) }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Anasayfa ", fontSize = 50.sp)

        val kisi = Users("Ömer",22,1.85f,true)
        val kisiJson = Gson().toJson(kisi)
        Button(onClick = { navController.navigate("sayfa_a/$kisiJson") }) {
            Text(text = "Sayfa A ya git.")
        }

        Text(text = "Sayaç : ${sayac.value}")
        Button(onClick = {sayac.value+=1}) {
            Text(text = "Arttır")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        NavigationPage()
    }
}