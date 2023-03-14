package com.example.composeloginsample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeloginsample.ui.theme.ComposeLoginSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoginSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    LoginUI(context = applicationContext)
                }
            }
        }
    }
}
@Composable
fun LoginUI(context: Context){

    var email by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}

    Column(     //since in the UI we need to arrange items vertically one after another we use column tag
        modifier = Modifier.fillMaxSize().padding(20.dp),   //padding in the entire container
        verticalArrangement = Arrangement.Center) {         //aligning the elements at the center for the whole container
        Text(
            text = "Login Here!",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()            //match parent
                .padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it},
            label = {Text("Email")},
            placeholder = {Text(text = "Enter your email")},
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it},
            label = {Text("Password")},
            placeholder = { Text(text = "Enter your password")},
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "info")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)     //giving the input type as password so that it is hidden
        )

        OutlinedButton(onClick = { checkCredentials(email,password,context)},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F78D1)),
            modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 15.dp)) {
            Text(
                text = "Login",
                color = Color.White,
                textAlign = TextAlign.Center)
        }

    }
}

fun checkCredentials(email: String, password: String, context: Context) {
    Toast.makeText(context, "$email --> $password", Toast.LENGTH_SHORT).show()
}