package com.example.mjrhoteis

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mjrhoteis.ui.theme.MJRHoteisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MJRHoteisTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { Home(navController) }
                        composable("TelaLogin") { TelaLogin(navController) }
                        composable("Categorias") { CategoriasScreen(navController) }
                        composable("DetalhesHoteis") { HoteisScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Scaffold { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(110.dp))
                Text(
                    text = "BEM VINDO AO",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Serif
                    ),
                    modifier = Modifier.padding(16.dp)
                )
                Image(painterResource(R.drawable.ic_logo), contentDescription = "Esta é a logo")
                ElevatedAssistChip(
                    onClick = {
                        navController.navigate("TelaLogin")
                    },
                    label = {
                        Text(
                            text = "ENTRAR",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 25.sp
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color(0xFF735A5A)
                    ),
                    modifier = Modifier.size(width = 200.dp, height = 55.dp)
                )
            }
        }
    }
}

@Composable
fun TelaLogin(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.size(400.dp),
        )
        Spacer(modifier = Modifier.height(32.dp))
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (email.isEmpty()) {
                    Text(text = "digite seu email...", color = Color.Gray)
                }
                innerTextField()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (password.isEmpty()) {
                    Text(text = "digite sua senha...", color = Color.Gray)
                }
                innerTextField()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "NÃO TENHO CADASTRO", fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("Categorias") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF735A5A)
            )
        ) {
            Text(text = "LOGIN", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CategoriasScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.size(400.dp),
        )
        Text(
            text = "CATEGORIA:",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "HOTÉIS",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.ic_hotel),
                contentDescription = "Hotel",
                modifier = Modifier
                    .size(370.dp)
                    .clickable { navController.navigate("DetalhesHoteis") }
            )
        }
    }
}

@Composable
fun HoteisScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .offset(y = (-40).dp) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.size(330.dp),
        )
        Text(
            text = "HOTÉIS",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        HotelCard(
            name = "Hotel Lagoas",
            location = "Bombinhas, SC",
            price = "R$ 1.100,00 P/dia",
            imageRes = R.drawable.ic_ht1,
            rating = 5
        )
        Spacer(modifier = Modifier.height(10.dp))
        HotelCard(
            name = "Hotel Olimpo",
            location = "São Paulo, SP",
            price = "R$ 950,00 P/dia",
            imageRes = R.drawable.ic_ht2,
            rating = 4
        )
        Spacer(modifier = Modifier.height(10.dp))
        HotelCard(
            name = "Hotel Caballero",
            location = "Gramado, RS",
            price = "R$ 970,00 P/dia",
            imageRes = R.drawable.ic_ht3,
            rating = 3
        )
        Spacer(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun HotelCard(name: String, location: String, price: String, imageRes: Int, rating: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(10.dp)),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = location, fontSize = 16.sp, color = Color.Gray)
                StarRating(rating = rating, modifier = Modifier.padding(top = 4.dp, bottom = 4.dp))
                Text(text = price, fontSize = 16.sp, color = Color.Green)
            }
        }
    }
}

@Composable
fun StarRating(rating: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        for (i in 1..5) {
            val imageRes = if (i <= rating) {
                R.drawable.ic_estrela
            } else {
                R.drawable.ic_estrelacinza
            }
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Estrelas",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
