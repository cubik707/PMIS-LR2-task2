package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task2.ui.theme.Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFDBD6F3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var textValue by rememberSaveable{ mutableStateOf("") }
        val MyName by remember{mutableStateOf("Демидовец Владислава Валерьевна")}
        Text(
            text = textValue,
            modifier = modifier.padding(3.dp),
            fontSize = 20.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = {
                    textValue = MyName
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C9393)),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "Вывести имя")
            }

            Button(
                onClick = {
                    textValue = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C9393)),
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(0.dp), // внутренний отступ
                modifier = Modifier
                    .padding(8.dp) // внешний отступ
                    .size(40.dp)
            ) {
                Text(text = "X", fontSize = 16.sp)
            }
        }
    }
}

fun onClick(textValue: String) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task2Theme {
        Greeting()
    }
}