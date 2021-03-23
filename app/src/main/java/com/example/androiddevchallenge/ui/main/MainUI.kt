package com.example.androiddevchallenge.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.*

@Preview("Dark Theme", widthDp = 375, heightDp = 875)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Preview("Light Theme", widthDp = 375, heightDp = 875)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        val dark = isSystemInDarkTheme()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(if(dark) R.drawable.ic_vector_header_dark else R.drawable.ic_vector_header),
                contentDescription = "Header",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(ratio = 1.2376f)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Spacer(
                    Modifier
                        .aspectRatio(ratio = 1.5f)
                        .fillMaxWidth()
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    ),
                    elevation = 10.dp,
                    backgroundColor = Color.White
                ) {
                    Header()
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        FirstRow()
                        SecondRow()
                        ThirdRow()
                        FourRow()

                    }
                }
            }

        }

    }
}

@Composable
fun Header(){
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            text = "Sunday, 19 May 2019  |  4:30PM",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = fontDefault,
                fontWeight = FontWeight.Normal
            ),
        )
        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 20.dp,
                bottomEnd = 0.dp,
                bottomStart = 20.dp
            ), backgroundColor = Color(
                0x140DA0EA
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mumbai, India",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = fontDefault,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF0DA0EA)
                    ),
                )
                Image(
                    painter = painterResource(R.drawable.ic_vector_location),
                    contentDescription = "Location"
                )
            }
        }
    }
}

@Composable
fun FirstRow(){
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
        ) {
        Column {
            Image(painter = painterResource(id = R.drawable.ic_vector_sunny),contentDescription = null,
            modifier = Modifier.size(40.dp,40.dp)
                )
            Text("Sunny",fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 18.sp)
        }

        Row{
            Text("33",fontWeight = FontWeight.Light,fontFamily = fontDefault,fontSize = 64.sp)
            Text(text = "°C",fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 24.sp,
                color = secondPrimary,
                modifier = Modifier.padding(top = 14.dp)
                )
        }

        Column {
            Row(verticalAlignment = Alignment.Top) {
               Text(text = "35°C",fontWeight = FontWeight.Light,fontFamily = fontDefault,fontSize = 16.sp,
                   color = secondPrimary)
                Image(painter = painterResource(id = R.drawable.ic_vector_up), contentDescription = "",
                    modifier = Modifier.padding(top = 4.dp,start = 2.dp))
            }
            Spacer(modifier = Modifier.size(12.dp))
            Row (verticalAlignment = Alignment.Bottom){
                Text(text = "27°C",fontWeight = FontWeight.Light,fontFamily = fontDefault,fontSize = 16.sp,
                    color = secondPrimary)
                Image(painter = painterResource(id = R.drawable.ic_vector_down), contentDescription = "",
                modifier = Modifier.padding(bottom = 4.dp,start = 2.dp)
                    )
            }
        }
    }
}

@Composable
fun GeneralUnit(resId:Int,title:String,subTitle:String){
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = painterResource(id = resId), contentDescription = "",
            modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = title,fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 16.sp,
            color = text_4)
        Text(text = subTitle,fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 9.sp,
            color = text_9)
    }
}

@Composable
fun GeneralDay(resId:Int,day:String,upTitle:String,downTitle:String){
    Card(shape = RoundedCornerShape(16.dp),elevation = 4.dp,modifier = Modifier
        .padding(
            start = 16.dp,
            top = 16.dp,
            bottom = 16.dp,
            end = 0.dp
        ),backgroundColor = Color.White,

        ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(18.dp)
        ) {
            Image(painter = painterResource(id = resId), contentDescription = "",
                modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(12.dp))
            Text(text = day,fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 16.sp,
                color = text_4)
            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = upTitle,fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 8.sp,
                        color = secondPrimary)
                    Image(painter = painterResource(id = R.drawable.ic_vector_up), contentDescription = "",
                        modifier = Modifier.size(width = 5.dp,height = 7.dp))
                }
                Spacer(modifier = Modifier.size(12.dp))
                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(text = downTitle,fontWeight = FontWeight.Medium,fontFamily = fontDefault,fontSize = 8.sp,
                        color = secondPrimary)
                    Image(painter = painterResource(id = R.drawable.ic_vector_down), contentDescription = "",
                        modifier = Modifier.size(width = 5.dp,height = 7.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SecondRow(){
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        GeneralUnit(resId = R.drawable.ic_vector_humidity, title = "49%", subTitle = "Humidity")
        GeneralUnit(resId = R.drawable.ic_vector_barometer, title = "1,007mBar", subTitle = "Pressure")
        GeneralUnit(resId = R.drawable.ic_vector_wind, title = "23 km/h", subTitle = "Wind")
    }
}

@Composable
fun ThirdRow(){
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        GeneralUnit(resId = R.drawable.ic_vector_sunrise, title = "6:03 AM", subTitle = "Sunrise")
        GeneralUnit(resId = R.drawable.ic_vector_sunset, title = "7:05 PM", subTitle = "Sunset")
        GeneralUnit(resId = R.drawable.ic_vector_daytime, title = "13h 1m", subTitle = "Daytime")
    }
}

@Composable
fun FourRow(){
    LazyRow {
        item {
            GeneralDay(resId = R.drawable.ic_vector_sunny, day = "Mon, 21", upTitle = "35°C", downTitle = "26°C")
            GeneralDay(resId = R.drawable.ic_vector_cloudy, day = "Tue, 22", upTitle = "35°C", downTitle = "27°C")
            GeneralDay(resId = R.drawable.ic_vector_hazy, day = "Wed, 23", upTitle = "34°C", downTitle = "29°C")
            GeneralDay(resId = R.drawable.ic_vector_cloudy, day = "Thu, 24", upTitle = "35°C", downTitle = "33°C")
            GeneralDay(resId = R.drawable.ic_vector_sunny, day = "Fri, 25", upTitle = "36°C", downTitle = "32°C")
            GeneralDay(resId = R.drawable.ic_vector_hazy, day = "Sa, 26", upTitle = "37°C", downTitle = "31°C")
            GeneralDay(resId = R.drawable.ic_vector_sunny, day = "Sun, 27", upTitle = "38°C", downTitle = "30°C")
        }
    }
}

