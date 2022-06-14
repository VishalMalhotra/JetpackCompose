package com.prepladder.medical.mydaggerhiltapp

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prepladder.medical.mydaggerhiltapp.ui.theme.ImageWithText

@ExperimentalFoundationApi
@Preview
@Composable
fun ProfileScreen() {
    var selectedTabByIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "MVISHAL25", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))

        HighlightSection(
            highlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Youtube"
                ),

                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Q&A"
                ),

                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Discord"
                ),

                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Telegram"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "PROFILE"
                ),
            )
        ) {
            selectedTabByIndex = it
        }

when(selectedTabByIndex){
    0 -> PostSection(posts = listOf(
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background),
        painterResource(id = R.drawable.ic_launcher_background)
    ),modifier = Modifier.fillMaxWidth()
    )

}
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier

    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )


        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Bell",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )



        Icon(
            painter = painterResource(id = R.drawable.ic_dot),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }

}

@Preview
@Composable
fun ProfileSection(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

            ) {
            RoundImage(
                image = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )

            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifier = Modifier.weight(7f))


        }
        ProfileDescrption(
            displayName = "Vishal Malhotra",
            description = "10 years of experience\n" + "Want to your app? Send me an email",
            url = "https://www.google.com",
            followedBy = listOf("codingFlow", "learncodeonline"),
            otherAccount = 100
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image, contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileStats(numberText = "73M", text = "Posts")
        ProfileStats(numberText = "39.3k", text = "Followers")
        ProfileStats(numberText = "59", text = "Following")
    }
}

@Composable
fun ProfileStats(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescrption(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherAccount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherAccount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherAccount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }

}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {

    val width = 95.dp
    val height = 35.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionableButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = width)
                .height(height)
        )
        ActionableButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = width)
                .height(height)
        )
        ActionableButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = width)
                .height(height)
        )
        ActionableButton(

            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )

    }

}

@Composable
fun ActionableButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}


@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {

    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlight[it].image,
                    modifier = Modifier.size(70.dp)
                )

                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactivecolor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {

        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactivecolor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactivecolor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}


@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.0f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it], contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White),
            )
        }
    }


}