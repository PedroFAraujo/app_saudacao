package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val image = painterResource(R.drawable.android_logo)
    val backgroundColor = Color(android.graphics.Color.parseColor("#1D361F")) // Cor de fundo em hexadecimal
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center, //centraliza verticalmente
            horizontalAlignment = Alignment.CenterHorizontally, //centraliza horizontalmente
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(R.string.string_logo_android),
                modifier = Modifier.size(200.dp)
            )
            BusinessCardTitle(
                title = stringResource(R.string.string_title),
                subtitle = stringResource(R.string.string_subtitle)
            )
        }
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
        IconTextRow(
            icon = Icons.Default.AccountCircle,
            text = stringResource(R.string.string_perfil_linkedin)
        )
        IconTextRow(
            icon = Icons.Default.Email,
            text = stringResource(R.string.string_email)
        )
    }
}

@Composable
private fun BusinessCardTitle(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        val textColor = Color(android.graphics.Color.parseColor("#ECE5DF")) // Cor do texto em hexadecimal
        Text(
            text = title,
            style = TextStyle(color = textColor, fontSize = 22.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
        )
        Text(
            text = subtitle,
            style = TextStyle(color = textColor, fontSize = 16.sp),
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Composable
private fun IconTextRow(icon: ImageVector, text: String) {
    val iconColor = Color(android.graphics.Color.parseColor("#CFE0BC")) // Cor do ícone em hexadecimal
    val textColor = Color(android.graphics.Color.parseColor("#ECE5DF")) // Cor do texto em hexadecimal
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}