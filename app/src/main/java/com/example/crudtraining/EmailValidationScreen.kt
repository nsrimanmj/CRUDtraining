package com.example.crudtraining

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crudtraining.composables.AnimatedButton
import com.example.crudtraining.composables.CustomTextFields

@Composable
fun EmailValidationScreen(modifier: Modifier = Modifier){
    val vm:SignUpViewModel = SignUpViewModel()
    vm.startCountDownTimer()
    Scaffold(
        modifier = modifier.background(Color.Transparent)
    ) {paddingValues ->
        var buttonVisibility by remember {
            mutableStateOf(false)
        }
        Image(
            painter = painterResource(id = R.drawable.signup_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Text(text = "Create an Account", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Enter the 6-digit code sent to", textAlign = TextAlign.Center, color = colorResource(id = R.color.MJLedBlue), fontSize = 20.sp, modifier = modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = vm.email, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "If the email is not in your Inbox, please check your Spam or Junk Mail folders.", color = Color.Red, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextFields(
                    value = vm.verificationCode,
                    onValueChange = {vm.verificationCode = it},
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    keyboardType = KeyboardType.Number,
                    labelText = "Verification Code"
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { vm.startCountDownTimer() }, modifier = Modifier.align(Alignment.End), enabled = !vm.isPlaying) {
                    Text(text = if(vm.isPlaying) vm.timerText else "Didn't receive the code")
                }
                AnimatedButton(enabled = vm.verificationCode.length > 5)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailValidationScreenPreview(){
    EmailValidationScreen()
}