package com.prepladder.medical.mydaggerhiltapp


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ProfileScreen()













/*            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenbox")
                val redbox = createRefFor("redbox")

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    height = Dimension.value(100.dp)
                    width = Dimension.value(100.dp)
                }

                constrain(redbox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    height = Dimension.value(100.dp)
                    width = Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox,redbox,chainStyle = ChainStyle.Packed)
            }

            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox")

                )
                Box(
                    modifier = Modifier
                        .layoutId("redbox")
                        .background(Color.Red)
                )

            }*/
        }
    }
}
