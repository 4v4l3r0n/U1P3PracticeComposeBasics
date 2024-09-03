package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticlePreview()
                    TaskManagerPreview()
                    ComposeQuadrantPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview(){
    ComposeArticle(
        headerImage = painterResource(R.drawable.bg_compose_background),
        title = stringResource(R.string.header_text),
        shortDesc = stringResource(R.string.text1),
        longDesc = stringResource(R.string.text2),
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ComposeArticle(
    headerImage: Painter,
    title: String,
    shortDesc: String,
    longDesc: String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Image(
            painter = headerImage,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDesc,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDesc,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview(){
    TaskManager(
        tick = painterResource(R.drawable.ic_task_completed),
        boldText = stringResource(R.string.bold_text),
        subText = stringResource(R.string.sub_text),
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun TaskManager(
    tick: Painter,
    boldText: String,
    subText: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = tick,
            contentDescription = null
        )
        Text(
            text = boldText,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = subText,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview(){
    ComposeQuadrant()
}

@Composable
fun ComposeQuadrant(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)){
            InfoCard(
                title = stringResource(R.string.top_left_title),
                description = stringResource(R.string.top_left_subtext),
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF))
            )
            InfoCard(
                title = stringResource(R.string.top_right_title),
                description = stringResource(R.string.top_right_subtext),
                modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF))
            )
        }
        Row(Modifier.weight(1f)){
            InfoCard(
                title = stringResource(R.string.bottom_left_title),
                description = stringResource(R.string.bottom_left_subtext),
                modifier = Modifier.weight(1f).background(Color(0xFFB69DF8))
            )
            InfoCard(
                title = stringResource(R.string.bottom_right_title),
                description = stringResource(R.string.bottom_right_subtext),
                modifier = Modifier.weight(1f).background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
private fun InfoCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier //takes parent modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp), //takes Modifier
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}
