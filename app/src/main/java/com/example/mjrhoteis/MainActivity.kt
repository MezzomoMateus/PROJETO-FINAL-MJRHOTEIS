package com.example.mjrhoteis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mjrhoteis.ui.theme.MJRHoteisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MJRHoteisTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home()
                }
            }
        }
    }
}


@Composable
fun Home(){
    Scaffold {
        paddingValues ->
        Column (Modifier.padding(paddingValues)){
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
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
                Image(painterResource(R.drawable.ic_logo), "Esta é a logo" )
                ElevatedAssistChip(
                    onClick = {},
                    label = { Text(
                        text = "ENTRAR",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 25.sp
                    ) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color(0xFF735A5A)
                    ),
                            modifier = Modifier.size(width = 200.dp, height = 55.dp)
                )




        }
    }
}
}


