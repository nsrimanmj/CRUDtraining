package com.example.crudtraining.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crudtraining.R
import kotlinx.coroutines.delay

@Composable
fun AnimatedButton() {
    var isLoading by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    var animating by remember { mutableStateOf(false) }


    val horizontalPadding by animateDpAsState(
        targetValue = if (animating) 160.dp else 0.dp,
        animationSpec = tween(durationMillis = 300),
        finishedListener = {
            if (animating) {
                showProgress = true
                animating = false
            }
        }
    )
    LaunchedEffect(isLoading) {
        if(isLoading){
            animating = true
            delay(3000)
            isLoading = false
            showProgress = false
        }
        else{
            animating = true
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)

    ) {
        if (showProgress) {
            CircularProgressIndicator(
                modifier = Modifier.padding(8.dp).size(30.dp),
                color = colorResource(id = R.color.validate_green)
            )


        } else {
            Button(
                onClick = {
                    isLoading = true
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.validate_green))
            ) {
                if(animating) Text("") else Text("VALIDATE")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedButtonPreview(){
    AnimatedButton()
}