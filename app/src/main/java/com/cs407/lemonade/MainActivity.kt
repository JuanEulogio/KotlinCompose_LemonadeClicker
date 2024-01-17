package com.cs407.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs407.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    imageAndTextApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun imageAndTextApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeAmount by remember { mutableStateOf(0) }


    //Scaffold has mult purposes such as nav, title, etc.
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    //changed container color to customize
                    containerColor = colorResource(id = R.color.babyYellow),
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background,
    ){
        when(currentStep){
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    //can hold image inside button
                    Button(
                        onClick = {
                            currentStep = 2
                            squeezeAmount = (2..4).random()
                                  },
                        //TODO: we can customize its shape. store our dimen values in res.values folder
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        //changed container color to customize
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.babyYellow))
                    ){
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.LemonTree),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(R.string.LemonTree),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 18.sp
                    )
                }
            }
            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Button(
                        onClick = {
                            squeezeAmount--;
                            if (squeezeAmount == 0) currentStep = 3;
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.babyYellow))
                    ){
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.Lemon),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.Lemon))
                }
            }
            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Button(
                        onClick = {
                            currentStep = 4;
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.babyYellow))
                    ){
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.GlassOfLemonade),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.GlassOfLemonade))
                }
            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Button(
                        onClick = {
                            currentStep = 1;
                        },
                        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.babyYellow))
                    ){
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.EmptyGlass),
                            modifier = Modifier
                                .wrapContentSize()
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.EmptyGlass))
                }
            }

        }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageAndText() {
    LemonadeTheme {
        imageAndTextApp();
    }
}