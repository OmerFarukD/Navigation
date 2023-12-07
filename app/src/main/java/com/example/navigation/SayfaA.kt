package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SayfaA(navController: NavController,users:Users){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "SayfaA", fontSize = 50.sp)


        Text(text = users.isim)
        Text(text = users.yas.toString())
        Text(text = users.boy.toString())
        Text(text = users.bekarMi.toString())


        Button(onClick = {navController.navigate("sayfa_b")  }) {
            Text(text = "Sayfa B ye git")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Geri Dön")
        }

    }
}