package com.example.admindashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.admindashboard.data.AdminPageData
import com.example.admindashboard.ui.theme.AdminDashboardTheme
import com.example.admindashboard.ui.theme.Maroon
import com.example.admindashboard.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminDashboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdminPage()
                }
            }
        }
    }
}

val adminfeatures1 = listOf(
    AdminPageData(
        icon = Icons.Default.Add,
        number = "25",
        description = "Total Refugees",
        color = PurpleGrey40

    ),

    AdminPageData(
        icon = Icons.Default.Phone,
        number = "36",
        description = "Verified Refugees",
        color = PurpleGrey40
    ),

    )

val adminfeatures2 = listOf(
    AdminPageData(
        icon = Icons.Default.AccountCircle,
        number = "25",
        description = "Unverified Refugees",
        color = Maroon

    ),

    AdminPageData(
        icon = Icons.Default.Email,
        number = "70",
        description = "Active Users",
        color = Maroon
    ),

    )


@Composable

fun AdminPage() {

    val Norm = Maroon
    Column() {
        Text(
            text = "Welcome, Norman",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )


        LazyRow {
            items(adminfeatures1.size) { index ->
                AdminLandingPageBox1(index = index)
            }}

        Spacer(modifier = Modifier.height(60.dp))

        LazyRow {
            items(adminfeatures2.size) { index ->
                AdminLandingPageBox2(index = index)
            }}

        Spacer(modifier = Modifier.height(80.dp))


        TextButton(
            modifier= Modifier
                .size(width = 300.dp, height = 50.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(color = Norm)
                .align(Alignment.CenterHorizontally)

            ,

            onClick = { /*TODO*/ }) {
            Text(text = "User Management",
                color = Color.White)
        }

        Spacer(modifier = Modifier.height(30.dp))


    }
}


@Composable
fun AdminLandingPageBox1(index: Int) {
    val feature = adminfeatures1[index]
    var lastItemPaddingEnd = 0.dp
    if (index == adminfeatures1.size - 1) {
        lastItemPaddingEnd = 16.dp}

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .clickable {  }

    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(feature.color)
                .width(180.dp)
                .height(180.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = feature.icon, contentDescription = "", tint = Color.White)
            Text(text = feature.number, color = Color.White, fontSize = 40.sp,  fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = feature.description, style = MaterialTheme.typography.labelMedium, color = Color.White)
//
        }
    }

}


@Composable
fun AdminLandingPageBox2(index: Int) {
    val feature = adminfeatures2[index]
    var lastItemPaddingEnd = 0.dp
    if (index == adminfeatures2.size - 1) {
        lastItemPaddingEnd = 16.dp}

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .clickable {  }

    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(feature.color)
                .width(180.dp)
                .height(180.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = feature.icon, contentDescription = "", tint = Color.White)
            Text(text = feature.number, color = Color.White, fontSize = 40.sp,  fontWeight = FontWeight.Bold )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = feature.description, style = MaterialTheme.typography.labelMedium, color = Color.White)
//
        }
    }

}