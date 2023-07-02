package com.example.signup_page_mockup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signup_page_mockup.ui.theme.Shapes
import com.example.signup_page_mockup.ui.theme.SignUp_page_mockupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUp_page_mockupTheme {
                // A surface container using the 'background' color from the theme
                googleButton();
            }
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
private  fun googlebuttonPreview(){
   googleButton();
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun googleButton(){
    var clicked by remember{ mutableStateOf(false) };
    Surface(
        onClick = {clicked=!clicked},
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color= Color.LightGray),
        color=MaterialTheme.colors.surface
    ) {
        Row(
            modifier=Modifier
                .padding(12.dp,12.dp,16.dp,12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "",
                tint=Color.Unspecified
            )
            Spacer(modifier= Modifier.width(8.dp))
            Text(text = "Google Sign Up")

        }
        Spacer(modifier = Modifier.padding(4.dp))
        if(clicked){
            CircularProgressIndicator(
                modifier= Modifier
                    .height(16.dp)
                    .width(16.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colors.primary
            )
        }
    }
}