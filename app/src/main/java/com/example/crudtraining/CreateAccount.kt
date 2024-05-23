package com.example.crudtraining

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateAccountScreen(modifier: Modifier = Modifier){

    Scaffold(
    modifier = modifier.background(Color.Transparent)
    ) {paddingValues ->
        Image(
            painter = painterResource(id = R.drawable.signup_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        var firstName by remember{
            mutableStateOf(TextFieldValue())
        }
        var lastName by remember{
            mutableStateOf(TextFieldValue())
        }
        var email by remember{
            mutableStateOf(TextFieldValue())
        }
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .padding(paddingValues)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Create an Account", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = modifier.padding(top = 24.dp))
                Spacer(modifier = modifier.height(12.dp))
                OutlinedTextField(value = firstName, onValueChange = {firstName = it}, modifier = modifier
                    .fillMaxWidth(),
                    label = { Text(text = "First Name")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(value = lastName, onValueChange = {lastName = it}, modifier = modifier
                    .fillMaxWidth(), label = { Text(
                    text = "Last Name"
                )},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)

                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(value = email, onValueChange = {email = it}, modifier = modifier
                    .fillMaxWidth(), label = { Text(
                    text = "Email"
                )},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done)

                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Please ensure you can access this email account readily. In the next screen you\'d need to enter the authentication code we\'d send to this email-id",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.MJLedBlue),
                    lineHeight = 16.sp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "By continuing You agree to our Terms of Service and Privacy Policy.")
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.background(Color.Transparent),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(id = R.color.MJLedBlue)
                        ),
                        shape = RectangleShape
                    ) {
                        Text(text = "BACK")
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.background(Color.Transparent),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = colorResource(id = R.color.MJLedBlue)
                        ),
                        shape = RectangleShape
                    ) {
                        Text(text = "NEXT")
                    }
                }

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CreateAccountPreview(){
    CreateAccountScreen()
}

