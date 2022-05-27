package com.prepladder.medical.mydaggerhiltapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val fontFamiliy = FontFamily(
                Font(R.font.robotomono_bold, FontWeight.ExtraBold)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Text(

                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(Color.Green,
                                fontSize = 30.sp)
                        ){
                            append("J")
                        }
                        append("etpack")
                        withStyle(
                            style = SpanStyle(Color.Green,
                                fontSize = 30.sp)
                        ){
                            append("C")
                        }
                        append("ompose")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamiliy,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline

                )
            }


            val painter = painterResource(id = R.drawable.img)
            val description = " IMAGE? "
            val title = " CRICKET IMAGE "

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight(0.5f)
                    .padding(16.dp)
            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }
        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier

    ) {

        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black,

                                    ),
                                startY = 300f
                            )
                        )
                )
                Box(
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(12.dp),

                    contentAlignment = Alignment.BottomStart
                ) {

                    Text(
                        text = "VISHAL MALHOTRA",
                        style = TextStyle(color = Color.White),
                        fontSize = 16.sp
                    )
                }
            }
        }

    }


}
