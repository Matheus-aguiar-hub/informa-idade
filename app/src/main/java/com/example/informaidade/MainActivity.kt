package com.example.informaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.informaidade.ui.theme.InformaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InformaIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicsComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicsComponentsScreen(modifier: Modifier = Modifier) {
    var textoIdade by remember { mutableStateOf("17") }

    //Usar essa variavel para validar a idade caso nao tiver nada ou letra retorna 0
    val idade = textoIdade.toIntOrNull() ?: 0

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Qual é a sua idade?",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(64, 110, 189, 255)
            )
        }//ROW

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Digite ou aperte os botões",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(21, 21, 21, 255)
            )
        }//ROW

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = textoIdade,
                onValueChange = { novoTexto ->
                    textoIdade = novoTexto
                },
                modifier = Modifier.padding(top = 16.dp),
                label = { Text("Idade") }
            )
        }//ROW

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    val atual = textoIdade.toIntOrNull() ?: 0
                    if (atual > 0) {
                        textoIdade = (atual - 1).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(64, 110, 189, 255)),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .size(56.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    modifier = Modifier.size(32.dp),
                    contentDescription = "Diminuir idade"
                )
            }//CONFIGURACAO DO BOTAO

            Button(
                onClick = {
                    val atual = textoIdade.toIntOrNull() ?: 0
                    if (atual < 180) {
                        textoIdade = (atual + 1).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(64, 110, 189, 255)),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .size(56.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    modifier = Modifier.size(32.dp),
                    contentDescription = "Aumentar idade"
                )
            }//CONFIGURACAO DO BOTAO
        }//BOTAO

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (idade < 0) {
                      "Número não é permitido"}
                        else if(idade > 180) {
                            "Número não permitido"}
                        else if(idade <= 17){
                            "Você é MENOR de idade"}
                else {  "Você é MAIOR de idade"},
                color = Color(64, 110, 189, 255),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }//ROW
    }//COLUMN
}//FUNCAO

